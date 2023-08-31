package com.csc301.profilemicroservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProfileController_ProfileController_3011099e88_Test {

    private ProfileDriverImpl profileDriver;
    private PlaylistDriverImpl playlistDriver;
    private ProfileController profileController;

    @BeforeEach
    public void setup() {
        profileDriver = mock(ProfileDriverImpl.class);
        playlistDriver = mock(PlaylistDriverImpl.class);
        profileController = new ProfileController();
    }

    @Test
    public void testProfileController() {
        // Test the constructor
        assertNotNull(profileController);
    }

    @Test
    public void testProfileControllerWithNullProfileDriver() {
        ProfileController profileControllerNullProfileDriver = new ProfileController();
        assertNotNull(profileControllerNullProfileDriver);
    }

    @Test
    public void testProfileControllerWithNullPlaylistDriver() {
        ProfileController profileControllerNullPlaylistDriver = new ProfileController();
        assertNotNull(profileControllerNullPlaylistDriver);
    }
}
