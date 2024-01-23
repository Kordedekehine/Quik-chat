
# **Introduction**
Quik chat is a simple web chatting app.

# **Setting up Kafka**
- Download the suitable binary version from  https://kafka.apache.org/downloads
- Extract the version and rename to simply *kafka* (note that after extraction, you will have something like kafka.2.3 bla bla)
- open the command line from the extracted kafka folder
- Then start the zookeeper server first using (I'm using windows):
  
  <bin\windows\zookeeper-server-start.bat config\zookeeper.properties>

  -Then start the kafka server using:
  
<bin\windows\kafka-server-start.bat config\server.properties>

-Then create the kafka topic (make sure the name of the created topic tally with the one in your code)

<bin\windows\kafka-topics --create --topic your-topic --bootstrap-server localhost:9092>

-Also make sure your kafka cmd port is same as specified port in your code.

-Set up the configuration and run.

DEMO
![Screenshot (191)](https://user-images.githubusercontent.com/84699953/218276526-afe798e5-9ab3-498b-8965-214f75c8d142.png)
![Screenshot (192)](https://user-images.githubusercontent.com/84699953/218276536-360e3d35-4f40-4cc1-b421-22bf8941a1aa.png)
![Screenshot (193)](https://user-images.githubusercontent.com/84699953/218276545-d4592084-61fe-4b0e-83c0-ba3d004a51df.png)
![Screenshot (194)](https://user-images.githubusercontent.com/84699953/218276550-73553720-8805-421c-bba7-a1959e158d04.png)
