# springboot-rabbitMQ
SpringBoot + RabbitMQ 

Steps to create the environment

1.) Install Erlang latest version.
2.) Install rabitmq latest version.
3.) To use the rabbit mq console u need to go to rmq command line then hit the below command.
  ---- >>> rabbitmq-plugins enable rabbitmq_management
4.) After this, go to browser and hit 
  ---- >>> http://localhost:15672/  
  ---- >>> username :: guest
  ---- >>> password :: guest
5.) Create Exchange and Queue and bind it using an routing key.
6.) Publish message to the exchange and check in your springboot console to check the Events name which is printing from your springboot application.
