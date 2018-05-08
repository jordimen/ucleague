package net.octae.ucleague.business.service.impl;

import net.octae.ucleague.business.service.util.EntityConverter;
import net.octae.ucleague.domain.Team;
import net.octae.ucleague.persistence.repository.TeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TeamServiceTest {

    @Mock
    private EntityConverter entityConverter;

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamServiceImpl taskService;

    @Test
    public void getTasksWithSuccess() {

        // Arrange


        // Act


        // Assert
    }

    @Test
    public void getTasksByCategories() {
    }

    @Test
    public void createTask() {
    }

    @Test
    public void deleteTask() {
    }

    @Test
    public void updateTaskCategory() {
    }

}