package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Victor Wardi - @victorwardi
 */
class TestServiceTest {

    @Test
    @DisplayName("Should return merged list with alternate elements")
    void shouldReturnMergedList() {
        //Given
        List<Integer> list1 = Arrays.asList(2, 4, 6, 8);
        List<Integer> list2 = Arrays.asList(3, 7);
        List<Integer> expectedMergedList = Arrays.asList(2, 3, 4, 7, 6, 8);

        //When
        final List<Integer> mergedList = TestService.mergeLists(list1, list2);

        //Then
        assertEquals(expectedMergedList, mergedList);
    }

    @Test
    @DisplayName("Should return an IllegalArgumentException when List 1 is null or empty")
    void shouldReturnIllegalArgumentException_whenList1IsInvalid() {

        //Given
        List<Integer> list1 = null;
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4);

        //When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> TestService.mergeLists(list1, list2));

        //Then
        assertTrue(exception.getMessage().contains("List 1 cannot be empty."));
    }

    @Test
    @DisplayName("Should return an IllegalArgumentException when List 2 is null or empty")
    void shouldReturnIllegalArgumentException_whenList2IsInvalid() {

        //Given
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = null;

        //When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> TestService.mergeLists(list1, list2));

        //Then
        assertTrue(exception.getMessage().contains("List 2 cannot be empty."));
    }
}