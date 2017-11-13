package fr.istic.m2.entities;


import fr.istic.m2.jackson.JacksonParsing;
import fr.istic.m2.spring.ActivityRepository;
import fr.istic.m2.spring.CityRepository;
import fr.istic.m2.spring.RegistrationRepository;
import fr.istic.m2.spring.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Component
@EnableScheduling
public class MeteoMail{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private JacksonParsing jackson;

    private List<User> userList;
    private List<Registration> registrationList;

    @Scheduled(cron = "*/10 * * * * *")
    public void scheduleMail(){
        userList = userRepository.findAll();


        for(User user : userList){
            List<Registration> registrationsList = registrationRepository.findByUser(user);

            for(Registration registration : registrationsList){
                List<Activity> activityList = new ArrayList<>();

                activityList.add(activityRepository.findByRegistration(registration));

                for(Activity activity : activityList){
                    City city = cityRepository.findByActivities(activity);

                    List<Meteo> meteoList = jackson.meteoParsing(city);

                    if(meteoList != null){
                        sendMail(user, activity, meteoList);
                    }
                }
            }
        }

    }

    public void sendMail(User user, Activity activity, List<Meteo> meteoList){
        final String username = "taalebonmaheu@gmail.com";
        final String password = "TaaLeBonMaheu2017";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            String msg;

            msg = "Dear "+user.getName()+","
                    + "\n\n This is the meteo for your activity : "+activity.getName()+"\n\n";

            for(Meteo meteo : meteoList){
                msg += "for the "+meteo.getDate()+"\n";
                msg+= meteo.getDescription()+", température de la journée : "+meteo.getTemperature();
            }

            msg+="Have a good day !";

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("taalebonmaheu@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user.getMail()));
            message.setSubject("Testing Subject");
            message.setText(msg);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
