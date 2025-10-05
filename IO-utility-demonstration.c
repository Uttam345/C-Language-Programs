#include <stdio.h>
#include "io_utils.h"

#define NAME_BUFFER_SIZE 50

int main() {
    int age;
    double weight;
    char name[NAME_BUFFER_SIZE];

    printf("--- User Data Entry ---\n\n");

    // --- Read an Integer ---
    if (read_integer("Please enter your age: ", &age) == 0) {
        printf("Great! Your age is %d.\n\n", age);
    } else {
        printf("Could not read your age.\n\n");
    }

    // --- Read a Double ---
    if (read_double("Please enter your weight in kg: ", &weight) == 0) {
        printf("Okay, your weight is %.2f kg.\n\n", weight);
    } else {
        printf("Could not read your weight.\n\n");
    }

    // --- Read a String ---
    if (read_line("Please enter your full name: ", name, NAME_BUFFER_SIZE) != NULL) {
        printf("Hello, %s!\n\n", name);
    } else {
        printf("Could not read your name.\n\n");
    }

    printf("--- End of Program ---\n");

    return 0;
}
