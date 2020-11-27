#include <Arduino.h>
#include <WiFi.h>
#include <HTTPClient.h>

const char* ssid = "toya123456825546";
const char* password = "03286241";

String endpoint = "http://10.3.145.165:8080/add-record";

unsigned long lastTime = 0;
unsigned long waitTime = 30;

void setup() {
  Serial.begin(115200);

  WiFi.begin(ssid, password);
  Serial.print("Connecting to ");
  Serial.print(ssid);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print('.');
  }

  Serial.println('\n');
  Serial.println("Connection established!");  
  Serial.print("IP address:\t");

  Serial.println(WiFi.localIP());

  randomSeed(analogRead(0));
}

void loop() {
  if ((millis() - lastTime) > waitTime) {

    //Check WiFi connection status
    if(WiFi.status()== WL_CONNECTED){
      HTTPClient http;

      String serverPath = endpoint + "";
      
      // Your api endpoint name with URL path or IP address with path
      http.begin(serverPath.c_str());
      
      // Send HTTP GET request
      http.addHeader("Content-Type", "text/plain");
      int httpResponseCode = http.POST("");
      
      if (httpResponseCode > 0) {
        Serial.print("HTTP Response code: ");
        Serial.println(httpResponseCode);
        String payload = http.getString().substring(0, 50);
        Serial.println(payload);
      }
      else {
        Serial.print("Error code: ");
        Serial.println(httpResponseCode);
      }
      // Free resources
      http.end();

      // Send an HTTP POST every random time (30s, 5min)
      waitTime = random(30*60, 5*60*60);
      Serial.print("Waiting: ");
      Serial.println(waitTime);
    }
    else {
      Serial.println("WiFi Disconnected");
      // Retry immediately
      waitTime = 0;
    }

    lastTime = millis();
  }
}