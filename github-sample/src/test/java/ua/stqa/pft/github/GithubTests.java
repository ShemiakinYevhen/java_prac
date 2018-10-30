package ua.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

    @Test
    public void testCommits() throws IOException {
        Github github = new RtGithub("7c5905dfd470ea5d212755ab664d5c53ce5f20de");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("ShemiakinYevhen", "java_prac")).commits();
        User shemiakinYevhen = github.users().get("ShemiakinYevhen");
        System.out.println(new User.Smart(shemiakinYevhen).bio());
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());
            System.out.println("********************************************************");
        }
    }
}
