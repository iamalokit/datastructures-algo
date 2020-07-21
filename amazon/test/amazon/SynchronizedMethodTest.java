package amazon;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.Test;

import com.amazon.algorithms.basic.SynchronizedMethod;

public class SynchronizedMethodTest {
	
	@Test
	public void givenMultiThread_whenNonSyncMethod() {
		ExecutorService service = Executors.newFixedThreadPool(3);
		SynchronizedMethod summation = new SynchronizedMethod();
		IntStream.range(0, 1000).forEach(count -> service.submit(summation :: calculate));
		try {
			service.awaitTermination(1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertEquals(1000, summation.getSum());
	}
}
