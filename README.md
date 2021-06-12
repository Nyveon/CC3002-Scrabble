# Scrabble

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

Interactive graphic programming language heavily inspired by 
[Scratch](https://scratch.mit.edu).
This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/), 
and aims purely to be used with the purpose of teaching in the context of the course 
_CC3002 Metodologías de Diseño y programación_ of the 
[_Computer Sciences Department (DCC)_](https://www.dcc.uchile.cl) of the 
_University of Chile_.

Estudiante: Eric Kirchgessner

Fecha comienzo: 08/Mayo/2021

---
Documentación externa del proyecto


## Variables

### Scrabble String
    ScrabbleString
    value <- Java String
#### Valid conversions:
* `toScrabbleString()`
#### Valid operations:
* `plus(other)` Note: Works as string concatenation.
  * with Scrabble String
  * with Scrabble Integer
  * with Scrabble Float
  * with Scrabble Binary
  * with Scrabble Bool


### Scrabble Bool
    ScrabbleBool
    value <- Java Boolean
#### Valid conversions:
* `toScrabbleString()` Note: Converts to '0' or '1', not 'true' or 'false'.
* `toScrabbleBool()`
#### Valid operations:
* `not()`
* `and(other)`
  * with Scrabble Bool: operates as expected.
  * with Scrabble Binary: applies boolean value to every binary digit.
* `or(other)`
  * with Scrabble Bool: operates as expected.
  * with Scrabble Binary: applies boolean value to every binary digit.


### Scrabble Float
    ScrabbleFloat
    value <- Java Double
    Note: Despite the name, it is actually a double, not a float.
#### Valid conversions:
* `toScrabbleString()`
* `toScrabbleFloat()`
#### Valid operations:
* `plus(other)`
  * with Scrabble Float
  * with Scrabble Int: Result is a Scrabble Float.
  * with Scrabble Binary: result is a Scrabble Float. 
* `minus(other)`
  * with Scrabble Float
  * with Scrabble Int: Result is a Scrabble Float.
  * with Scrabble Binary: result is a Scrabble Float. 
* `times(other)`
  * with Scrabble Float
  * with Scrabble Int: Result is a Scrabble Float.
  * with Scrabble Binary: result is a Scrabble Float. 
* `div(other)`
  * with Scrabble Float
  * with Scrabble Int: Result is a Scrabble Float.
  * with Scrabble Binary: result is a Scrabble Float. 


### Scrabble Integer
    ScrabbleInt
    value <- Java Integer
#### Valid conversions:
* `toScrabbleString()`
* `toScrabbleFloat()` Note: Value becomes a double with decimal value 0.
* `toScrabbleInt()`
* `toScrabbleBinary()` Note: is 2's complement.
#### Valid operations:
* `plus(other)`
  * with Scrabble Float: Result is a Scrabble Float.
  * with Scrabble Int
  * with Scrabble Binary: result is a Scrabble Int.
* `minus(other)`
  * with Scrabble Float: Result is a Scrabble Float.
  * with Scrabble Int
  * with Scrabble Binary: result is a Scrabble Int.
* `times(other)`
  * with Scrabble Float: Result is a Scrabble Float.
  * with Scrabble Int
  * with Scrabble Binary: result is a Scrabble Int.
* `div(other)`
  * with Scrabble Float: Result is a Scrabble Float.
  * with Scrabble Int: Whole division (result is a Scrabble Int).
  * with Scrabble Binary: result is a Scrabble Int.

### Scrabble Binary
    ScrabbleBinary
    value <- Java String
    Note: Value will always be 32 characters long!
#### Valid conversions:
* `toScrabbleString()`
* `toScrabbleFloat()` Note: is actually just Binary -> Int -> Double.
* `toScrabbleInt()` Note: is 2's complement.
* `toScrabbleBinary()`
#### Valid operations:
* `plus(other)`
  * with Scrabble Int: result is a Scrabble Binary
  * with Scrabble Binary
* `minus(other)`
  * with Scrabble Int: result is a Scrabble Binary
  * with Scrabble Binary
* `times(other)`
  * with Scrabble Int: result is a Scrabble Binary
  * with Scrabble Binary
* `div(other)`
  * with Scrabble Int: Whole division (result is a Scrabble Binary).
  * with Scrabble Binary
* `not()` Note: Inverts each character (all 32) individually.
* `and(other)`
  * with Scrabble Bool: applies boolean value to every binary digit.
  * with Scrabble Binary: operates each corresponding digit with each-other.
* `or(other)`
  * with Scrabble Bool: applies boolean value to every binary digit.
  * with Scrabble Binary: operates each corresponding digit with each-other.












Si estás leyendo esto, que tengas un buen dia/noche c:

![Scratch Cat](https://en.scratch-wiki.info/w/images/thumb/ScratchCat-Small.png/200px-ScratchCat-Small.png)
