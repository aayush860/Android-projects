package com.example.anew.ifm;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Belal on 10/30/2015.
 */

//Class is extending AsyncTask because this class is going to perform a networking operation
public class sendmail2 extends AsyncTask<Void,Void,Void> {
    public static String xx;
    //Declaring Variables
    private Context context;
    private Session session;

    //Information to send email
    private String email;
    private String subject;
    private String message;

    //Progressdialog to show while sending email
    private ProgressDialog progressDialog;


    //Class Constructor
    public sendmail2(Context context, String email, String subject, String message){
        //Initializing variables
        this.context = context;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        //Showing progress dialog while sending email
        progressDialog = ProgressDialog.show(context,"Sending Customer Order Recipt","Please wait...",false,false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
      //  Intent ixx=new Intent(this,lastcl.class);                                                //snkjcnjskcnjskcnknsjndkj
        //startActivity(ixx);
        //Dismissing the progress dialog
        progressDialog.dismiss();

        //Showing a success message
//        Toast.makeText(context,"Order Confirmed",Toast.LENGTH_LONG).show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        //Creating properties
        Properties props = new Properties();

        //Configuring properties for gmail
        //If you are not using gmail you may need to change the values
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        //Creating a new session
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    //Authenticating the password
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Config.EMAIL, Config.PASSWORD);
                    }
                });

        try {
            //Creating MimeMessage object
            MimeMessage mm = new MimeMessage(session);
            //      Toast.makeText(context,"1",Toast.LENGTH_SHORT).show();
            //Setting sender address
            mm.setFrom(new InternetAddress(Config.EMAIL));
//            Toast.makeText(context,"2",Toast.LENGTH_SHORT).show();
            //Adding receiver
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            //          Toast.makeText(context,"3",Toast.LENGTH_SHORT).show();
            //Adding subject
            mm.setSubject(subject);
            //        Toast.makeText(context,"4",Toast.LENGTH_SHORT).show();
            //Adding message
            mm.setText(message);
            //    Toast.makeText(context,"5",Toast.LENGTH_SHORT).show();

            //Sending email
            Transport.send(mm);
            //  Toast.makeText(context,"VJBHHBJJHJV",Toast.LENGTH_SHORT).show();
            xx="done";
        } catch (MessagingException e) {
            Toast.makeText(context,"notsent",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        return null;
    }
}