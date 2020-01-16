package com.mikedriessen.discord;

import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.event.domain.message.MessageCreateEvent;

import java.util.ArrayList;
import java.util.List;

public class DiscordBot {

    List<String> myListOfString;
    //leuke discord bot spullen.


    public static void main(String[] arse){
        System.out.println("bami bal");

        List<String> myListOfString = new ArrayList<String>();
        myListOfString.add("Car");
        myListOfString.add("Truck");
        System.out.println(myListOfString);
        DiscordBot bot = new DiscordBot();

        bot.startBot();

    }
    public void startBot(){
        DiscordClient client = new DiscordClientBuilder("NjY2OTk2NDQ5MDc0MjE2OTkw.Xh8S5A.asc5JJhS13RB8DPIVJ5YKe40u7c").build();

        client.getEventDispatcher().on(MessageCreateEvent.class).subscribe((MessageCreateEvent event)->{
            System.out.println(event.getMessage().getContent().get());
            if (!event.getMessage().getAuthor().get().isBot()) {
                if(event.getMessage().getContent().get().contentEquals("ping")) {
                    event.getMessage().getChannel().block().createMessage("gay").block();
                }
            }
        });
        client.login().block();


    }


}
