package com.alex.studentquestionaire;

import com.alex.studentquestionaire.domain.ConsoleContext;
import com.alex.studentquestionaire.service.ConsoleService;
import com.alex.studentquestionaire.service.ConsoleServiceImpl;
import lombok.NonNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.lang.Nullable;

import java.io.PrintStream;
import java.util.Scanner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;

public class ConsoleServiceTest {

    private @Nullable ConsoleService sut;
    private final @NonNull String stub = "Stub";
    private @Nullable
    PrintStream out;
    private @Nullable
    Scanner scanner;

    @Before
    public void setUp() {
        scanner = mock(Scanner.class);
        out = mock(PrintStream.class);
        sut = new ConsoleServiceImpl(new ConsoleContext(out, scanner));
    }

    @Test
    public void itReads() {
        //given
        //when
        assert scanner != null;
        when(scanner.nextLine()).thenReturn(stub);

        //then
        assert sut != null;
        assertEquals(stub,sut.readLine());
    }

    @Test
    public void itPrints() {
        //given
        //when
        assert sut != null;
        sut.println(stub);

        //then
        assert out != null;
        verify(out).println(stub);
    }


}
