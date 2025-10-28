package hw5.flyweight;

public class FlyweightDriverTest {
    @Test
    void testDriverIntegrationCreatesSharedStyles() {
        FlyweightDriver driver = new FlyweightDriver();
        driver.createDemoDocument();
        int poolSize = driver.getFactoryPoolSize();
        assertTrue(poolSize >= 4);
    }

}
