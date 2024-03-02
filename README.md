# Solution-Kata-Connect4

Solución al Kata de Codewars llamado Connect4 en Java

https://www.codewars.com/kata/586c0909c1923fdb89002031/java

En este Kata se nos plantea la tarea de programar la lógica detrás del popular juego Conecta 4.

* La zona de juego consta de 7 columnas y 6 filas.
* El input será un array de integers que representarán en qué columna decide el jugador lanzar la ficha.
* Debemos tener en cuenta que después de una jugada válida, en el siguiente turno cambiará el jugador.
* Cuando un jugador consiga alinear 4 fichas vertical, horizontal o diagonalmente, deberá aparecer el mensaje "Player N wins", donde los jugadores serán 1 y 2.
* Si un jugador intenta insertar una ficha en una columna llena deberá aparecer el mensaje "Column full!" y la siguiente jugada pertenecerá al mismo jugador.
* Si un jugador ha conseguido la victoria, en cualquier jugada posterior, debe aparecer el mensaje "Game has finished!"
* En cualquier otra situación deberá aparecer el mensaje "Player N has a turn" y finalizar el turno.
* Siempre empezará jugador el jugador 1.
