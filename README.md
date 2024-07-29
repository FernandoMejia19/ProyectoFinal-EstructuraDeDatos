## DATOS

ESTRUCTURA DE DATOS "PROYECTO FINAL"

Realizado por:Fernando Mejia >>> jmejiaq1@est.ups.edu.ec


## PROBLEMA

Se debe crear un laberinto segun la necesidad del Usuario donde se debe
encontrar camino optimo del Laberinto el cual tendra un inicio y fin que 
debe ser ingresado por el Usuario.

## PROPUESTA DE SOLUCIÓN

Para generar el laberinto se utilizara herramientas para craer la interfaz de usuario
y generar metodos para encontrar el camino optimo del mismo.

**Interfaz de Usuario
Para la generar una interfaz de usuario llamativa y funiconal se maqueto en illustrador 
donde se definio una tipograifa para el titulo principal y para el resto de textos, tambien
se creo una paleta de colores para tener una armonia visual.

-AWT(Abstraact Window Toolkit)
Esta API es un conjunto de herramientas que nos ayuda a crear interfaces graficas de usuario(GUI).
Donde nos proporciona ventanas,botones y menus para poder interactuar con el sistema operativo.
En este caso nos permite desarrollar una aplicacion de manera sencilla para presentar la solucion
a problema planteado.
**PROGRAMACION RECURSIVA
Esta tecnica nose permite llamarse asi misma para dividir el problema en otros mas pequeños.

**PROGRAMACION DINÁMICA
Esta tecnica ayuda a optimizar ya que ya que divide el problema en otros mas pequeños con la gran 
diferencia de que va almacenaando sus soluciones para evitar calcular nuevamente.

**BFS (Breadth-First Search)>>>busqueda de anchura
Esta algoritmo recorre elemtos en grafos o arboles donde explora o recorre los nodos nivel por nivel, este da
comienzo en el nodo raiz y explora a todos sus vecinos antes de pasar a los vecinos del siguiente nivel.
Este metodo asegura encontrar el camino mas corto en un grafo no ponderado.

**DFS(Depth-First Search)>>Busqueda en profundidad
Este algoritmo se utiliza para recorre o buscar elementos en grafos o arboles que funcion explorando lo mas profundo
posible a lo largo de cada rama antes de retorceder, este comienza en el nodo raiz y explora cada rama antes de moverse
a otra, la utiidad de este metodo es para encontrar componenetes conectados.

**JAVA
Se utilizo Java ya que es un lenguaje que se vio en todo este ciclo y el cual tambien es versatil y orientado a objetos,es
utilizado para desarrollar una amplia variedad de aplicaciones.Java nos ofrece una variedad de apis que se pueden usar para
soporte lo que facilita la construccion de aplicaciones eficientes.
En Java se implemento el patron MVC donde se uso AWT para crear la interfaz grafica aplicando de la siguiente manera:
-Model:Gestiona los datosy la logica de la aplicacion que el usuario no tiene conocimiento
-View:Se encarga de la parte visual donde se utiliza componentes de AWT.
-Controller:Maneja la interaccion del usuario actualizando el modelo y vista en respuesta a las entradas del usuario.

**RESULTADO



## Conclusiones

El metodo de BFS generalmente es la mejor opcion para encontrar el camino mas corto, pero en este caso me parece que el
metodo de DFS es mas rapido ya que con este metodo se obtines una solucion mas rapida con muchos obstaculos.

## Consideraciones

Generar  la implentacion en otros tipos de juegos o simulacions donde se pueda analizar e mejor manera los metodos
estudiados.






