package grafos1;

import java.util.ArrayList;

public class Grafos1 {

    public static void main(String[] args) {
        Plano elPlano = new Plano(10);
        
        elPlano.agregarPunto(new Punto(11, 14, 2));
        elPlano.agregarPunto(new Punto(0, 25, 16));
        elPlano.agregarPunto(new Punto(200, 26, 35));
        elPlano.agregarPunto(new Punto(101, 1, 15));
        elPlano.agregarPunto(new Punto(1, 140, 20));
        elPlano.agregarPunto(new Punto(0, 0, 100));
        elPlano.agregarPunto(new Punto(5, 10, 20));
        elPlano.agregarPunto(new Punto(1, 100, 200));
        elPlano.agregarPunto(new Punto(11, 140, 200));
        elPlano.agregarPunto(new Punto(5, 55, 50));
        
        elPlano.losPuntos();
        
        elPlano.clasificaPuntos();
        
        int [] ruta1 = {1, 2, 6, 9, 10};
        int [] ruta2 = {1, 3, 5, 7, 9, 10};
        int [] ruta3 = {1, 4, 5, 7, 9, 10};
        int [] ruta4 = {1, 3, 5, 6, 9, 10};
        int [] ruta5 = {1, 4, 5, 8, 10};
        int [] ruta6 = {1, 4, 5, 6, 9, 10};
        
        Grafo elGrafo = new Grafo();
        
        elGrafo.lasRutas(ruta1, elPlano);
        elGrafo.lasRutas(ruta2, elPlano);
        elGrafo.lasRutas(ruta3, elPlano);
        elGrafo.lasRutas(ruta4, elPlano);
        elGrafo.lasRutas(ruta5, elPlano);
        elGrafo.lasRutas(ruta6, elPlano);
        
        elGrafo.elGrafo();
    }
}

class Punto {
    private int x;
    private int y;
    private int z;
    
    public Punto() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    
    public Punto(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
    
    // M??todo que retorna el punto en formato (x, y, z)
    public String punto() {
        return "(" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")";
    }
}

class Plano {
    // Propiedades de la clase Plano
    // ArrayList que almacena los puntos registrados en el plano 3D
    private ArrayList<Punto> puntos;
    
    // Arreglos que almacenan las coordenadas x, y, z por separado
    private int [] coordenadasX;
    private int [] coordenadasY;
    private int [] coordenadasZ;
    
    // Constructor de la clase Plano que inicializa el ArrayList
    public Plano() {
        this.puntos = new ArrayList<>();
    }
    
    // Constructor de la clase Plano que inicializa el ArrayList y define 
    // el tama??o de los arreglos de acuerdo al n??mero de puntos que 
    // contendr?? el plano
    public Plano(int m) {
        this.puntos = new ArrayList<>();
        this.coordenadasX = new int[m];
        this.coordenadasY = new int[m];
        this.coordenadasZ = new int[m];
    }

    // Los seters y los geters
    public ArrayList<Punto> getPuntos() {
        return puntos;
    }

    public void setPuntos(ArrayList<Punto> puntos) {
        this.puntos = puntos;
    }

    public int[] getCoordenadasX() {
        return coordenadasX;
    }

    public void setCoordenadasX(int[] coordenadasX) {
        this.coordenadasX = coordenadasX;
    }

    public int[] getCoordenadasY() {
        return coordenadasY;
    }

    public void setCoordenadasY(int[] coordenadasY) {
        this.coordenadasY = coordenadasY;
    }

    public int[] getCoordenadasZ() {
        return coordenadasZ;
    }

    public void setCoordenadasZ(int[] coordenadasZ) {
        this.coordenadasZ = coordenadasZ;
    }
    
    // M??todo que agrega un punto en el ArrayList puntos
    public void agregarPunto(Punto punto) {
        this.puntos.add(punto);
    }
    
    // M??todo que imprime los puntos del plano en formato 
    // Punto i (Pi): (x, y, z); recorriendo el ArrayList de puntos
    public void losPuntos() {
        System.out.println("Los puntos:");
        for (int p = 0; p < this.getPuntos().size(); p++) {
            System.out.println("Punto " + (p + 1) + " (P" + (p + 1) + "): " + this.getPuntos().get(p).punto());
        }
    }
    
    // M??todo que coloca las coordenas x, y, z en su respectivo arreglo
    // recorriendo el ArrayList de puntos
    public void clasificaPuntos() {
        for (int i = 0; i < this.getPuntos().size(); i++) {
            coordenadasX[i] = this.getPuntos().get(i).getX();
            coordenadasY[i] = this.getPuntos().get(i).getY();
            coordenadasZ[i] = this.getPuntos().get(i).getZ();
        }
    }
    
    // M??todo que imprime las coordenadas x de los puntos en formato 
    // X = {x1, x2, x3, ..., xm} recorriendo el arreglo coordenadasX
    public void lasX() {
        System.out.println("Las coordenadas x:");
        System.out.print("X = {");
        for (int x = 0; x < this.getCoordenadasX().length; x++) {
            if (x == this.getCoordenadasX().length - 1) {
                System.out.print(this.getCoordenadasX()[x]);
            } else {
                System.out.print(this.getCoordenadasX()[x] + ", ");
            }
        }
        System.out.println("}");
    }
    
    // M??todo que imprime las coordenadas y de los puntos en formato 
    // Y = {y1, y2, y3, ..., ym} recorriendo el arreglo coordenadasY
    public void lasY() {
        System.out.println("Las coordenadas y:");
        System.out.print("Y = {");
        for (int y = 0; y < this.getCoordenadasY().length; y++) {
            if (y == this.getCoordenadasY().length - 1) {
                System.out.print(this.getCoordenadasY()[y]);
            } else {
                System.out.print(this.getCoordenadasY()[y] + ", ");
            }
        }
        System.out.println("}");
    }
    
    // M??todo que imprime las coordenadas z de los puntos en formato 
    // Z = {z1, z2, z3, ..., zm} recorriendo el arreglo coordenadasX
    public void lasZ() {
        System.out.println("Las coordenadas z:");
        System.out.print("Z = {");
        for (int z = 0; z < this.getCoordenadasZ().length; z++) {
            if (z == this.getCoordenadasZ().length - 1) {
                System.out.print(this.getCoordenadasZ()[z]);
            } else {
                System.out.print(this.getCoordenadasZ()[z] + ", ");
            }
        }
        System.out.println("}");
    }
    
    // M??todo que busca y devuelve un Punto dado unPunto
    public Punto buscarPunto(Punto unPunto) {
        Punto p = new Punto();
        
        for (Punto x : this.puntos) {
            if (x.equals(unPunto)) {
                p = x;
            }
        }
        
        return p;
    }
    
    // M??todo que calcula la distancia entre dos puntos dado los ??ndices de los mismos
    // en base a la f??rmula: d(Pi, Pj) = RaizCuadrada((xi-xj)^2 + (yi-yj)^2 + (zi-zj)^2)
    public double distanciaDosPuntos(int indice1, int indice2) {
        double dcX;
        double dcY;
        double dcZ;
        
        dcX = Math.pow((this.getCoordenadasX()[indice1 - 1] - this.getCoordenadasX()[indice2 - 1]), 2);
        dcY = Math.pow((this.getCoordenadasY()[indice1 - 1] - this.getCoordenadasY()[indice2 - 1]), 2);
        dcZ = Math.pow((this.getCoordenadasZ()[indice1 - 1] - this.getCoordenadasZ()[indice2 - 1]), 2);
        
        return Math.sqrt(dcX + dcY + dcZ);
    }
}

class Grafo {
    private double [][] adyacentes;
    
    public Grafo() {
        adyacentes = new double[10][10];
    }
    
    public void lasRutas(int[] ruta, Plano p) {
        for (int k = 0; k < ruta.length - 1; k++) {
            adyacentes[ruta[k] - 1][ruta[k + 1] - 1] = p.distanciaDosPuntos(ruta[k], ruta[k + 1]);
        }
    }

    public double[][] getAdyacentes() {
        return adyacentes;
    }

    public void setAdyacentes(double[][] adyacentes) {
        this.adyacentes = adyacentes;
    }

    // M??todo que imprime el grafo 
    public void elGrafo() {
        System.out.println("El grafo:");
        for (int i = 0; i < getAdyacentes()[0].length; i++) {
            System.out.print("\t" + "P" + (i + 1) + "\t");
        }
        System.out.println();
        
        for (int i = 0; i < getAdyacentes().length; i++) {
            System.out.print("P" + (i + 1) + ":     ");
            for (int j = 0; j < getAdyacentes()[i].length; j++) {
                System.out.printf(Math.round(getAdyacentes()[i][j]) + "\t\t");
            }
            System.out.println();
        }
    }
}