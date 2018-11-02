package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.media.FacebookPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User izaura = new YGeneration("Izaura");
        User jennifer = new Millenials("Jennifer");
        User brian = new ZGeneration("Brian");


        //When
        String izauraShares = izaura.sharePost();
        System.out.println("Izaura: " + izauraShares);
        String jenniferShares = jennifer.sharePost();
        System.out.println("Jennifer: " + jenniferShares);
        String brianShares = brian.sharePost();
        System.out.println("Brian: " + brianShares);

        //Then
        Assert.assertEquals("Message published on Facebook", izauraShares);
        Assert.assertEquals("Message published on Twitter", jenniferShares);
        Assert.assertEquals("Message sent with Snapchat", brianShares);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User jennifer = new Millenials("Jennifer");

        //When
        String jenniferShares = jennifer.sharePost();
        System.out.println("Jennifer: " + jenniferShares);
        jennifer.setSocialPublisher(new FacebookPublisher());
        jenniferShares = jennifer.sharePost();
        System.out.println("Now Jennifer shares: " + jenniferShares);

        //Then
        Assert.assertEquals("Message published on Facebook", jenniferShares);
    }
}
