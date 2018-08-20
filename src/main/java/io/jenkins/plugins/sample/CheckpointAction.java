package io.jenkins.plugins.sample;

import hudson.model.*;
import hudson.model.queue.QueueTaskFuture;
import jenkins.model.Jenkins;
import jenkins.model.RunAction2;
import org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition;
import org.jenkinsci.plugins.workflow.flow.FlowDefinition;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;
import org.jenkinsci.plugins.workflow.job.WorkflowRun;
import org.junit.Rule;
import org.jvnet.hudson.test.JenkinsRule;

import javax.annotation.CheckForNull;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckpointAction implements Action {

    private static final Logger LOG = Logger.getLogger(CheckpointAction.class.getName());
    private final AbstractProject project;

    @Rule
    public JenkinsRule jenkins = new JenkinsRule();

    public CheckpointAction(AbstractProject abstractProject) {
        this.project = abstractProject;
    }

    public void printJobCode() {
        List<WorkflowJob> jobs = Jenkins.getInstanceOrNull().getAllItems(WorkflowJob.class);

        for (WorkflowJob job : jobs) {
            try {
                WorkflowRun completedBuild = jenkins.assertBuildStatusSuccess(job.scheduleBuild2(0));

                for (Action action : completedBuild.getAllActions()) {

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }





    }

    @CheckForNull
    @Override
    public String getDisplayName() {
        return "Build from Checkpoint";
    }

    @CheckForNull
    @Override
    public String getUrlName() {
        return "checkpoint";
    }

    @CheckForNull
    @Override
    public String getIconFileName() {
        return "clock.png";
    }

}
