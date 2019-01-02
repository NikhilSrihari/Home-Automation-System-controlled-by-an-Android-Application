#include <SPI.h>
#include <WiFi.h>

char ssid[] = "nikhilwifi";  
char pass[] = "12345678";  
int status = WL_IDLE_STATUS;
char server[] = "www.nikhilsrihari.site90.net";    //website....start with www.
WiFiClient client;
int socket1=2;
int socket2=3;
int socket3=5;
int socket4=6;
int socket5=9;
// 0 to 255
int speed0=0;
int speed1=50;
int speed2=100;
int speed3=150;
int speed4=200;
int speed5=255;


char prev[11];

void setup() {
  Serial.begin(9600); 
  // check for the presence of the shield:
  if (WiFi.status() == WL_NO_SHIELD) {
    Serial.println("WiFi shield not present"); 
    while(true);
  } 
  // attempt to connect to Wifi network:
  while (status != WL_CONNECTED) { 
    Serial.print("Attempting to connect to SSID: ");
    Serial.println(ssid);
    // Connect to WPA/WPA2 network. Change this line if using open or WEP network:    
    status = WiFi.begin(ssid, pass);
    delay(2000);
  }
  pinMode(socket1,OUTPUT);
  pinMode(socket2,OUTPUT);
  pinMode(socket3,OUTPUT);
  pinMode(socket4,OUTPUT);
  pinMode(socket5,OUTPUT);
  digitalWrite(socket1,LOW);
  digitalWrite(socket2,LOW);
  digitalWrite(socket3,LOW);
  digitalWrite(socket4,LOW);
  digitalWrite(socket5,LOW);
  Serial.println("Connected to wifi");
  printWifiStatus();
  prev[0]='$';prev[10]='*';
  prev[1]='0';prev[2]='0';prev[3]='0';prev[4]='0';prev[5]='0';prev[6]='0';prev[7]='0';prev[8]='0';prev[9]='0';
}


int cnt=0;
char data[11];

void loop() {
  //Connecting to website.....
  Serial.println("Starting connection to server");
  if (client.connect(server, 80)) {
    // Connection done...HTTP request:
    Serial.println("connected to server");
    client.println("GET /index.php HTTP/1.1");
    client.println("Host: www.nikhilsrihari.site90.net");
    client.println("Connection: close");
    client.println();
    Serial.println("data sent");
    
    
    cnt=0;
    char c;
    //Read incoming data...
    while(1) {
      if (client.available()) {
        c = client.read();
        if (c=='$' || cnt>0) {
          data[cnt]=c;cnt++;
        } 
        Serial.write(c);
      }
      if (cnt==11){
        cnt=0;break;
      }
    }
  
    Serial.println();
    Serial.write(data[0]);Serial.write(data[1]);Serial.write(data[2]);Serial.write(data[3]);Serial.write(data[4]);Serial.write(data[5]);Serial.write(data[6]);Serial.write(data[7]);Serial.write(data[8]);
    Serial.write(data[9]);Serial.write(data[10]);
    
    Serial.write(prev[0]);Serial.write(prev[1]);Serial.write(prev[2]);Serial.write(prev[3]);Serial.write(prev[4]);Serial.write(prev[5]);Serial.write(prev[6]);Serial.write(prev[7]);Serial.write(prev[8]);
    Serial.write(prev[9]);Serial.write(prev[10]);
 
 
    if (data[0]== '$' && data[10]=='*') {
       if ( (data[1]!=prev[1] || data[2]!=prev[2]) || (((data[3]!=prev[3] ||data[4]!=prev[4]) ||(data[4]!=prev[4] ||data[5]!=prev[5])) ||((data[6]!=prev[6] ||data[7]!=prev[7]) ||(data[8]!=prev[8] ||data[9]!=prev[9])))) {
         if (data[1]=='1') { digitalWrite(socket1,HIGH);Serial.println("digitalWrite(socket1,HIGH)");}
         else {digitalWrite(socket1,LOW);Serial.println("digitalWrite(socket1,LOW)");}
         if (data[2]=='1') {digitalWrite(socket2,HIGH);Serial.println("digitalWrite(socket2,HIGH)");}
         else {digitalWrite(socket2,LOW);Serial.println("digitalWrite(socket2,LOW)");}
         if (data[3]=='1') {digitalWrite(socket3,HIGH);Serial.println("digitalWrite(socket3,HIGH)");}
         else {digitalWrite(socket3,LOW);Serial.println("digitalWrite(socket3,LOW)");}
         if (data[4]=='1') {digitalWrite(socket4,HIGH);Serial.println("digitalWrite(socket4,HIGH)");}
         else {digitalWrite(socket4,LOW);Serial.println("digitalWrite(socket4,LOW)");}
         if (data[5]=='1') {
           if (data[9]=='0')
           {  analogWrite(socket5,speed0);
              Serial.println("analogWrite(socket5,speed0)");
           }
           else if (data[9]=='1')
           {  analogWrite(socket5,speed1);
              Serial.println("analogWrite(socket5,speed1)");
           }
           else if (data[9]=='2')
           {  analogWrite(socket5,speed2);
              Serial.println("analogWrite(socket5,speed2)");
           }
           else if (data[9]=='3')
           {  analogWrite(socket5,speed3);
              Serial.println("analogWrite(socket5,speed3)");  
           }
           else if (data[9]=='4')
           {  analogWrite(socket5,speed4);
              Serial.println("analogWrite(socket5,speed4)");
           }
           else if (data[9]=='5')
           {  analogWrite(socket5,speed5);
              Serial.println("analogWrite(socket5,speed5)");
           }
           else if (data[9]=='6')
           {  digitalWrite(socket5,LOW);
              Serial.println("digitalWrite(socket5,LOW)");
           }
         }
         else {
           digitalWrite(socket5,LOW);
         }     
       }
    }
 
    prev[0]=data[0];
    prev[1]=data[1];
    prev[2]=data[2];
    prev[3]=data[3];
    prev[4]=data[4];
    prev[5]=data[5];
    prev[6]=data[6];
    prev[7]=data[7];
    prev[8]=data[8];
    prev[9]=data[9];
    prev[10]=data[10];
  } 
  
  
  // if the server's disconnected, stop the client:
  if (!client.connected()) {
    Serial.println();
    Serial.println("disconnecting from server.");
    client.stop();    
  }
  client.stop();  
  delay(5000);
  
}







void printWifiStatus() {
  // print the SSID of the network you're attached to:
  Serial.print("SSID: ");
  Serial.println(WiFi.SSID());

  // print your WiFi shield's IP address:
  IPAddress ip = WiFi.localIP();
  Serial.print("IP Address: ");
  Serial.println(ip);

  // print the received signal strength:
  long rssi = WiFi.RSSI();
  Serial.print("signal strength (RSSI):");
  Serial.print(rssi);
  Serial.println(" dBm");
}
