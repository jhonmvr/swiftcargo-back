
package com.siwft.cargo.service;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Firebase Cloud Messaging (FCM) snippets for documentation.
 */
@Service
@Slf4j
public class GoogleClientService {



	public static void main(String[] args) {
		System.out.println("PROBANDO MI CODIGO FIREBASE");
		
		GoogleClientService gs =new GoogleClientService();
		
		try {
			//gs.initializeFirebase();
			//gs.initializeFirebase();
			gs.sendToToken("dYAak5hYQiKEbDaptmYOlc:APA91bHmERjbwMp1p9lr6dmgINV3tBzAQm_cg0kuLW23gO6speov9xmassjE0qZX_2CjZurmxkbi3wJ3Ush8zFl-1MQrxIT2pmLo49cTxiRUneULe_M7MSf0jSkBj7KAFP5iEByQ8qTb",
					"Titulo1","Mensaje1");
			gs.sendToToken("dYAak5hYQiKEbDaptmYOlc:APA91bHmERjbwMp1p9lr6dmgINV3tBzAQm_cg0kuLW23gO6speov9xmassjE0qZX_2CjZurmxkbi3wJ3Ush8zFl-1MQrxIT2pmLo49cTxiRUneULe_M7MSf0jSkBj7KAFP5iEByQ8qTb",
					"Titulo2","Mensaje2");
			gs.sendToToken("dYAak5hYQiKEbDaptmYOlc:APA91bHmERjbwMp1p9lr6dmgINV3tBzAQm_cg0kuLW23gO6speov9xmassjE0qZX_2CjZurmxkbi3wJ3Ush8zFl-1MQrxIT2pmLo49cTxiRUneULe_M7MSf0jSkBj7KAFP5iEByQ8qTb",
					"Titulo3","Mensaje3");
			gs.sendToToken("dYAak5hYQiKEbDaptmYOlc:APA91bHmERjbwMp1p9lr6dmgINV3tBzAQm_cg0kuLW23gO6speov9xmassjE0qZX_2CjZurmxkbi3wJ3Ush8zFl-1MQrxIT2pmLo49cTxiRUneULe_M7MSf0jSkBj7KAFP5iEByQ8qTb",
					"Titulo1","Mensaje1");
			gs.sendToToken("dYAak5hYQiKEbDaptmYOlc:APA91bHmERjbwMp1p9lr6dmgINV3tBzAQm_cg0kuLW23gO6speov9xmassjE0qZX_2CjZurmxkbi3wJ3Ush8zFl-1MQrxIT2pmLo49cTxiRUneULe_M7MSf0jSkBj7KAFP5iEByQ8qTb",
					"Titulo2","Mensaje2");
			gs.sendToToken("dYAak5hYQiKEbDaptmYOlc:APA91bHmERjbwMp1p9lr6dmgINV3tBzAQm_cg0kuLW23gO6speov9xmassjE0qZX_2CjZurmxkbi3wJ3Ush8zFl-1MQrxIT2pmLo49cTxiRUneULe_M7MSf0jSkBj7KAFP5iEByQ8qTb",
					"Titulo3","Mensaje3");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<printStackTrace>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			e.printStackTrace();
		}
		
	}
	/*public GoogleClientService() {
		log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<entra a GoogleClientService>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		try {
			this.initializeFirebase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	public void initializeFirebase() throws FileNotFoundException, IOException {
		log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<entra a initializeFirebase>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		if( FirebaseApp.getApps().isEmpty()) {

			File file = new File("C:\\WORKSPACE\\CHANDRESH\\UNIVERSIDAD\\SWIFT_CARGO\\switfcargo-service.json");
			//File file = new File("C:\\Users\\JhonM\\Downloads\\firebase.json");
	     
	        FileInputStream serviceAccount = new FileInputStream(file);
	        FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
	        FirebaseApp.initializeApp(options);
		}
		
       
    }

  public void sendToToken(String registrationToken, String titulo, String mensaje)  {
    try {
		// [START send_to_token]
		// This registration token comes from the client FCM SDKs.
		  log.info("<<<=====sendToToken====>>>");
		this.initializeFirebase();

		// See documentation on defining a message payload.
		Notification notificacion = Notification.builder().setTitle(titulo).setBody(mensaje).build();
		
		Message message = Message.builder()
		    .setNotification(notificacion)
		    .setToken(registrationToken)
		    //.setWebpushConfig(WebpushConfig.builder().putHeader("urgen", "5").build())
		    //.putData("mensaje", mensaje)
		    //.setAndroidConfig(AndroidConfig.builder().setPriority(Priority.HIGH).setCollapseKey("12345").build())
		    .build();

		// Send a message to the device corresponding to the provided
		// registration token.
		log.info("<<<=====notificacion====>>>");
		log.info("<<<=====titulo====>>>"+titulo);
		log.info("<<<=====mensaje====>>>"+mensaje);
		log.info("<<<=====token====>>>"+registrationToken);
		String response = FirebaseMessaging.getInstance().send(message);
		
		// Response is a message ID string.
		log.info("Successfully sent message: " + response);
		// [END send_to_token]
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		log.info("NO SE PUDO ENVIAR EL MENSAJE PUSH TOKEN" + registrationToken);
	}
  }
  

  public void sendToTopic() throws FirebaseMessagingException {
    // [START send_to_topic]
    // The topic name can be optionally prefixed with "/topics/".
    String topic = "highScores";

    // See documentation on defining a message payload.
    Message message = Message.builder()
        .putData("score", "850")
        .putData("time", "2:45")
        .setTopic(topic)
        .build();

    // Send a message to the devices subscribed to the provided topic.
    String response = FirebaseMessaging.getInstance().send(message);
    // Response is a message ID string.
    System.out.println("Successfully sent message: " + response);
    // [END send_to_topic]
  }

  public void sendToCondition() throws FirebaseMessagingException {
    // [START send_to_condition]
    // Define a condition which will send to devices which are subscribed
    // to either the Google stock or the tech industry topics.
    String condition = "'stock-GOOG' in topics || 'industry-tech' in topics";

    // See documentation on defining a message payload.
    Message message = Message.builder()
        .setNotification(Notification.builder()
            .setTitle("$GOOG up 1.43% on the day")
            .setBody("$GOOG gained 11.80 points to close at 835.67, up 1.43% on the day.")
            .build())
        .setCondition(condition)
        .build();

    // Send a message to devices subscribed to the combination of topics
    // specified by the provided condition.
    String response = FirebaseMessaging.getInstance().send(message);
    // Response is a message ID string.
    System.out.println("Successfully sent message: " + response);
    // [END send_to_condition]
  }

  public void sendDryRun() throws FirebaseMessagingException {
    Message message = Message.builder()
        .putData("score", "850")
        .putData("time", "2:45")
        .setToken("token")
        .build();

    // [START send_dry_run]
    // Send a message in the dry run mode.
    boolean dryRun = true;
    String response = FirebaseMessaging.getInstance().send(message, dryRun);
    // Response is a message ID string.
    System.out.println("Dry run successful: " + response);
    // [END send_dry_run]
  }

  public void sendAll() throws FirebaseMessagingException {
    String registrationToken = "YOUR_REGISTRATION_TOKEN";

    // [START send_all]
    // Create a list containing up to 500 messages.
    List<Message> messages = Arrays.asList(
        Message.builder()
            .setNotification(Notification.builder()
                .setTitle("Price drop")
                .setBody("5% off all electronics")
                .build())
            .setToken(registrationToken)
            .build(),
        // ...
        Message.builder()
            .setNotification(Notification.builder()
                .setTitle("Price drop")
                .setBody("2% off all books")
                .build())
            .setTopic("readers-club")
            .build()
    );

    BatchResponse response = FirebaseMessaging.getInstance().sendAll(messages);
    // See the BatchResponse reference documentation
    // for the contents of response.
    System.out.println(response.getSuccessCount() + " messages were sent successfully");
    // [END send_all]
  }

  public void sendMulticast() throws FirebaseMessagingException {
    // [START send_multicast]
    // Create a list containing up to 500 registration tokens.
    // These registration tokens come from the client FCM SDKs.
    List<String> registrationTokens = Arrays.asList(
        "YOUR_REGISTRATION_TOKEN_1",
        // ...
        "YOUR_REGISTRATION_TOKEN_n"
    );

    MulticastMessage message = MulticastMessage.builder()
        .putData("score", "850")
        .putData("time", "2:45")
        .addAllTokens(registrationTokens)
        .build();
    BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);
    // See the BatchResponse reference documentation
    // for the contents of response.
    System.out.println(response.getSuccessCount() + " messages were sent successfully");
    // [END send_multicast]
  }

  public void sendMulticastAndHandleErrors() throws FirebaseMessagingException {
    // [START send_multicast_error]
    // These registration tokens come from the client FCM SDKs.
    List<String> registrationTokens = Arrays.asList(
        "YOUR_REGISTRATION_TOKEN_1",
        // ...
        "YOUR_REGISTRATION_TOKEN_n"
    );

    MulticastMessage message = MulticastMessage.builder()
        .putData("score", "850")
        .putData("time", "2:45")
        .addAllTokens(registrationTokens)
        .build();
    BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);
    if (response.getFailureCount() > 0) {
      List<SendResponse> responses = response.getResponses();
      List<String> failedTokens = new ArrayList<>();
      for (int i = 0; i < responses.size(); i++) {
        if (!responses.get(i).isSuccessful()) {
          // The order of responses corresponds to the order of the registration tokens.
          failedTokens.add(registrationTokens.get(i));
        }
      }

      System.out.println("List of tokens that caused failures: " + failedTokens);
    }
    // [END send_multicast_error]
  }

  public Message androidMessage() {
    // [START android_message]
    Message message = Message.builder()
        .setAndroidConfig(AndroidConfig.builder()
            .setTtl(3600 * 1000) // 1 hour in milliseconds
            .setPriority(AndroidConfig.Priority.NORMAL)
            .setNotification(AndroidNotification.builder()
                .setTitle("$GOOG up 1.43% on the day")
                .setBody("$GOOG gained 11.80 points to close at 835.67, up 1.43% on the day.")
                .setIcon("stock_ticker_update")
                .setColor("#f45342")
                .build())
            .build())
        .setTopic("industry-tech")
        .build();
    // [END android_message]
    return message;
  }

  public Message apnsMessage() {
    // [START apns_message]
    Message message = Message.builder()
        .setApnsConfig(ApnsConfig.builder()
            .putHeader("apns-priority", "10")
            .setAps(Aps.builder()
                .setAlert(ApsAlert.builder()
                    .setTitle("$GOOG up 1.43% on the day")
                    .setBody("$GOOG gained 11.80 points to close at 835.67, up 1.43% on the day.")
                    .build())
                .setBadge(42)
                .build())
            .build())
        .setTopic("industry-tech")
        .build();
    // [END apns_message]
    return message;
  }

  public Message webpushMessage() {
    // [START webpush_message]
    Message message = Message.builder()
        .setWebpushConfig(WebpushConfig.builder()
            .setNotification(new WebpushNotification(
                "$GOOG up 1.43% on the day",
                "$GOOG gained 11.80 points to close at 835.67, up 1.43% on the day.",
                "https://my-server/icon.png"))
            .setFcmOptions(WebpushFcmOptions.withLink("https://my-server/page-to-open-on-click"))
            .build())
        .setTopic("industry-tech")
        .build();
    // [END webpush_message]
    return message;
  }

  public Message allPlatformsMessage() {
    // [START multi_platforms_message]
    Message message = Message.builder()
        .setNotification(Notification.builder()
            .setTitle("$GOOG up 1.43% on the day")
            .setBody("$GOOG gained 11.80 points to close at 835.67, up 1.43% on the day.")
            .build())
        .setAndroidConfig(AndroidConfig.builder()
            .setTtl(3600 * 1000)
            .setNotification(AndroidNotification.builder()
                .setIcon("stock_ticker_update")
                .setColor("#f45342")
                .build())
            .build())
        .setApnsConfig(ApnsConfig.builder()
            .setAps(Aps.builder()
                .setBadge(42)
                .build())
            .build())
        .setTopic("industry-tech")
        .build();
    // [END multi_platforms_message]
    return message;
  }

  public void subscribeToTopic() throws FirebaseMessagingException {
    String topic = "highScores";
    // [START subscribe]
    // These registration tokens come from the client FCM SDKs.
    List<String> registrationTokens = Arrays.asList(
        "YOUR_REGISTRATION_TOKEN_1",
        // ...
        "YOUR_REGISTRATION_TOKEN_n"
    );

    // Subscribe the devices corresponding to the registration tokens to the
    // topic.
    TopicManagementResponse response = FirebaseMessaging.getInstance().subscribeToTopic(
        registrationTokens, topic);
    // See the TopicManagementResponse reference documentation
    // for the contents of response.
    System.out.println(response.getSuccessCount() + " tokens were subscribed successfully");
    // [END subscribe]
  }

  public void unsubscribeFromTopic() throws FirebaseMessagingException {
    String topic = "highScores";
    // [START unsubscribe]
    // These registration tokens come from the client FCM SDKs.
    List<String> registrationTokens = Arrays.asList(
        "YOUR_REGISTRATION_TOKEN_1",
        // ...
        "YOUR_REGISTRATION_TOKEN_n"
    );

    // Unsubscribe the devices corresponding to the registration tokens from
    // the topic.
    TopicManagementResponse response = FirebaseMessaging.getInstance().unsubscribeFromTopic(
        registrationTokens, topic);
    // See the TopicManagementResponse reference documentation
    // for the contents of response.
    System.out.println(response.getSuccessCount() + " tokens were unsubscribed successfully");
    // [END unsubscribe]
  }

}