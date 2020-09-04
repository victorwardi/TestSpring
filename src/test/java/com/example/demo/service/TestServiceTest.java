package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Victor Wardi - @victorwardi
 */
class TestServiceTest {

    @Test
    @DisplayName("Should return Merged List")
    void shouldReturnMergedList() {
        List<Integer> list1 = Arrays.asList(2, 4, 6, 8);
        List<Integer> list2 = Arrays.asList(3, 7);
        final List<Integer> mergedList = TestService.mergeLists(list1, list2);
        assertThat(mergedList).hasSameElementsAs(Arrays.asList(2, 3, 4, 7, 6, 8));
    }

    @Test
    @DisplayName("Should return an IllegalArgumentException when List 1 is null or empty")
    void shouldReturnIllegalArgumentException_whenList1IsInvalid() {
        List<Integer> list1 = null;
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4);
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> TestService.mergeLists(list1, list2));
        assertTrue(exception.getMessage().contains("List 1 cannot be empty."));
    }

    @Test
    @DisplayName("Should return an IllegalArgumentException when List 2 is null or empty")
    void shouldReturnIllegalArgumentException_whenList2IsInvalid() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = null;
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> TestService.mergeLists(list1, list2));
        assertTrue(exception.getMessage().contains("List 2 cannot be empty."));
    }
}