JAVAC = javac
JAVA = java
RM = rm -f

RUTA = com/andres/juego/main/App
RUTAALT = com/andres/juego/main/

correr1:
	$(JAVA) $(RUTA)

correr2:
	$(JAVA) $(RUTAALT)Gui

compilar1:
	$(JAVAC) $(RUTA).java

compilar2:
	$(JAVAC) $(RUTAALT)Gui.java
	

limpiar:
	find . -name "*.class" -delete

# q de quick para pruebas rapidas
q: limpiar compilar1 correr1

#  c de correr - el cambio es para diferenciar gui y consola
c: limpiar compilar2 correr2