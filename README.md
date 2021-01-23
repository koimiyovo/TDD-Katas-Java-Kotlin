# TDD-Katas-Java-Kotlin
Some common katas implementation in Java and Kotlin

**1. Bowling game**

The game consists of 10 frames as shown above.  In each frame, the player has two opportunities to knock down 10 pins. The score for the frame is the total number of pins knocked down, plus bonuses for strikes and spares. A spare is when the player knocks down all 10 pins in two tries.  The bonus for that frame is the number of pins knocked down by the next roll. So in frame 3 above, the score is 10 (the total number knocked down)plus a bonus of 5 (the number of pins knocked down on the next roll.) A strike is when the player knocks down all 10 pins on his first try.  The bonus for that frame is the value of the next two balls rolled. In the tenth frame, a player who rolls a spare or strike is allowed to roll the extra ball to complete the frame.  However, no more than three balls can be rolled in the tenth frame.

Write a class named “BowlngGame” that has two methods :

* Roll(int pins) is called each time the player rolls a ball. The argument is the number of pins knocked down.
* Score() : int is called only at the very end of the game. It returns the total score for that game.

**2. FizzBuzz**

Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and five print "FizzBuzz"

**3. String calculator (By https://osherove.com/tdd-kata-1/)**

Create a simple String calculator with a method signature:

———————————————

int Add(string numbers)

———————————————

The method can take up to two numbers, separated by commas, and will return their sum. 
for example “” or “1” or “1,2” as inputs.
(for an empty string it will return 0)

Hints:
——————
 - Start with the simplest test case of an empty string and move to one and two numbers
 - Remember to solve things as simply as possible so that you force yourself to write tests you did not think about
 - Remember to refactor after each passing test
 
———————————————————————————————

Allow the Add method to handle an unknown amount of numbers

————————————————————————————————

* Allow the Add method to handle new lines between numbers (instead of commas).
the following input is ok: “1\n2,3” (will equal 6)
the following input is NOT ok: “1,\n” (not need to prove it - just clarifying)

——————————————————————————————-

* Support different delimiters
to change a delimiter, the beginning of the string will contain a separate line that looks like this: “//[delimiter]\n[numbers…]” for example “//;\n1;2” should return three where the default delimiter is ‘;’ .
the first line is optional. all existing scenarios should still be supported

————————————————————————————————

* Calling Add with a negative number will throw an exception “negatives not allowed” - and the negative that was passed. 
if there are multiple negatives, show all of them in the exception message.

————————————————————————————————

STOP HERE if you are a beginner. Continue if you can finish the steps so far in less than 30 minutes.

————————————————————————————————

* Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2

————————————————————————————————

* Delimiters can be of any length with the following format: “//[delimiter]\n” for example: “//[***]\n1***2***3” should return 6

————————————————————————————————

* Allow multiple delimiters like this: “//[delim1][delim2]\n” for example “//[*][%]\n1*2%3” should return 6.

————————————————————————————————

* make sure you can also handle multiple delimiters with length longer than one char

————————————————————————————————

**4. Sales taxes problem (By https://github.com/xpeppers/sales-taxes-problem)**

This problem requires some kind of input. You are free to implement any mechanism for feeding input into your solution (for example, using hard coded data within a unit test). You should provide sufficient evidence that your solution is complete by, as a minimum, indicating that it works correctly against the supplied test data.

## PROBLEM: SALES TAXES

**Basic sales tax** is applicable at a rate of **10%** on all goods, **except** books, food, and medical products that are exempt. **Import duty** is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.

When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

Write an application that prints out the receipt details for these shopping baskets...

```
INPUT:

Input 1:
2 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85

Input 2:
1 imported box of chocolates at 10.00
1 imported bottle of perfume at 47.50

Input 3:
1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
3 box of imported chocolates at 11.25

OUTPUT

Output 1:
2 book: 24.98
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 42.32

Output 2:
1 imported box of chocolates: 10.50
1 imported bottle of perfume: 54.65
Sales Taxes: 7.65
Total: 65.15

Output 3:
1 imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 9.75
3 imported box of chocolates: 35.55
Sales Taxes: 7.90
Total: 98.38
```

## General requirements
- You may use whatever programming language/platform you prefer. Use something that you know well.
- You must release your work with an OSI-approved open source license of your choice.
- You must deliver the sources of your application, with a README that explains how to compile and run it.
- Add the code to your own Github account and send us the link.

**IMPORTANT:**  Implement the requirements focusing on **writing the best code** you can produce.


**5. Racing car katas : https://github.com/emilybache/Racing-Car-Katas**


