import java.util.concurrent.LinkedBlockingQueue;

import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;

public class test {

	public static void main(String[] args) {
		LinkedBlockingQueue 
        Spider.create(new GithubRepoPageProcessor()).addUrl("https://github.com/code4craft").thread(5).run();
    }

}
