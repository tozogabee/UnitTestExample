package com.test;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class HelloWorldTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder(new File("target"));

    @Before
    public void setUp() {
        System.out.println("Before each test");
    }

    @After
    public void tearDown() {
        System.out.println("After each test");
    }

    @BeforeClass
    public static void init() {
        System.out.println("Before class");
    }

    @AfterClass
    public static void shutdown() {
        System.out.println("After class");
    }

    @Test
    public void givenDiana_whenInvokeSayHello_thenReturnCorrectMessage() {
        String result = HelloWorld.sayHello("Diana");

        assertThat(result, is("Hello Diana"));
    }

    @Test
    public void givenFrank_whenInvokeSayHello_thenReturnCorrectMessage() {
        String result = HelloWorld.sayHello("Frank");

        assertThat(result, is("Hello Frank"));
    }

    @Test
    public void givenNullName_thenThrowException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Name must not be null");

        HelloWorld.sayHello(null);
    }

    @Test
    public void shouldCreateSubFolderWithTestName() {
        File result = HelloWorld.createTestFile(temporaryFolder.getRoot());

        assertThat(result, is(new File(temporaryFolder.getRoot().getAbsoluteFile() + "/test")));
        assertThat(result.exists(), is(true));
    }

    @Test
    public void givenDianaAndJohn_thenReturnTwoHello() {
        List<String> names = Arrays.asList("Diana", "John");

        List<String> result = HelloWorld.sayHelloToLotOfPeople(names);

        assertThat(result, hasSize(2));
        assertThat(result, hasItem("Hello Diana"));
        assertThat(result, hasItem("Hello John"));
    }

}