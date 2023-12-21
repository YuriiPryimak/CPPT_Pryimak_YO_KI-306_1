import os

size = int(input("\nВведіть розмір квадратної матриці: "))
# Виділення пам'яті
arr = [[' ' for _ in range(size - 2)] for _ in range(size - 2)]

filler = input("\nВведіть символ-заповнювач: ")
if len(filler) == 1:
    with open("Lab1.txt", "w") as fout:
        print()
        for i in range(size - 2):
            if i == 0 or i == size - 3:
                for j in range(size - 2):
                    arr[i][j] = filler
                    print(f" {arr[i][j]}", end="")
                    fout.write(f" {arr[i][j]}")
            else:
                for j in range(2):
                    arr[i][j] = filler
                    if j == 1:
                        for _ in range(1, size - 3):
                            print("  ", end="")
                            fout.write("  ")
                    fout.write(f" {arr[i][j]}")
                    print(f" {arr[i][j]}", end="")
            print(" ")
            fout.write(" \n")
else:
    if not filler:
        print("\nНе введено символ заповнювач!")
    else:
        print("\nЗабагато символів заповнювачів!")

print()