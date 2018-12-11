package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static String PalabraMayorLongitud(String cadena)
    {
        String[] array = cadena.split(" ");
        int i;
        int max = 0;

        for (i = 1; i < array.length; i++)
        {
            if (array[i].length() > array[max].length())
            {
                max = i;
            }
        }
        return array[max];
    }

    public static String NumeroTelefonico(String cadena)
    {
        //Número Telefónico: 5256284000
        //Nueva Cadena: (52)-5-6284000

        String c2 = "";
        int i;

        for (i = 0; i < cadena.length(); i++)
        {
            if (i == 0)
            {
                c2 = c2 + '(' + cadena.charAt(i);
            } else if (i == 1)
            {
                c2 = c2 + cadena.charAt(i) + ")-";
            } else if (i == 2)
            {
                c2 = c2 + cadena.charAt(i) + '-' + cadena.substring(2);
            }
        }
        return c2;
    }

    public static String IntercalaCadenas(String cadena1, String cadena2)
    {
        String copia = "";
        int i;
        int min = Math.min(cadena1.length(), cadena2.length());

        for (i = 0; i < min; i++)
        {
            copia = copia + cadena1.charAt(i);
            copia = copia + cadena2.charAt(i);
        }

        if (cadena1.length() > min)
        {
            copia = copia + cadena1.substring(i);
        }

        if (cadena2.length() > min)
        {
            copia = copia + cadena2.substring(i);
        }

        return copia;
    }

    public static String LetrasNoAparecen(String cadena)
    {
        String abc = "abcdefghijklmnñopkrstuvwxyz";
        String noAparecen = "";
        int i, j;
        int seRepite;

        for (i = 0; i < abc.length(); i++)
        {
            char letra = abc.charAt(i);
            seRepite = 0;
            for (j = 0; j < cadena.length(); j++)
            {
                if (letra == cadena.charAt(j))
                {
                    seRepite++;
                }
            }
            if (seRepite == 0)
            {
                noAparecen += letra;
            }
        }
        return noAparecen;
    }

    public static int PorcentajePalabras(String cadena)
    {
        int menos5 = 0;
        int porcentaje;
        int i;
        String[] a = cadena.split(" ");

        for (i = 0; i < a.length; i++)
        {
            if (a[i].length() < 5)
            {
                menos5++;
            }
        }
        porcentaje = (menos5 * 100) / a.length;
        return porcentaje;

    }

    public static void VisualizaPalabras(String cadena)
    {
        String[] a = cadena.split(" ");
        int i;

        for (i = 0; i < a.length; i++)
        {
            System.out.println(a[i] + " = " + a[i].length());
        }
    }

    public static void RepiteCaracter(int n, char c)
    {
        int i;
        for (i = 0; i < n; i++)
        {
            System.out.print(c);
        }
    }

    public static void FrecuenciaVocales(String cadena)
    {
        int contador;
        int i;
        String a = "aeiou";
        int[] vocales = new int[5];

        for (i = 0; i < cadena.length(); i++)
        {
            switch (cadena.charAt(i))
            {
                case 'a':
                    vocales[0] += 1;
                    break;
                case 'e':
                    vocales[1] += 1;
                    break;
                case 'i':
                    vocales[2] += 1;
                    break;
                case 'o':
                    vocales[3] += 1;
                    break;
                case 'u':
                    vocales[4] += 1;
                    break;
                default:
                    break;
            }
        }

        for (i = 0; i < vocales.length; i++)
        {
            contador = 0;
            System.out.print(a.charAt(i) + " " + vocales[i] + " ");
            while (contador <= vocales[i])   //Las iteraciones serán iguales al número de vocales[i]
            {
                System.out.print('*');
                contador++;
            }
            System.out.println();
        }

    }

    public static int SumaUnoContador(int n, int[] nVocales)  //**NO ENTIENDO bien esta función
    {
        int aux = n;
        int i;
        int siMas = 0;
        for (i = 0; i < nVocales.length; i++)
        {
            if (nVocales[i] >= 2 || nVocales[i] == 0)   //  {8,4,2,1,1} {2,1,1,1,1}
            {
                siMas++;
            }
        }
        if (siMas == 1 || siMas == 0)
        {
            aux += 1;
        }
        return aux;  //tocamilotuke
    }

    public static int CuatroVocales(String cadena)
    {
        String vocales = "aeiou";
        int[] cuentaVocales = new int[vocales.length()];
        int contador = 0;
        int i, k;
        String[] a = cadena.toLowerCase().split(" ");
        String palabra = "";
        //El tocamilotuke no seca bien la ropatesusolis palitroque y escobilla
        for (i = 0; i < a.length; i++)
        {
            cuentaVocales[0] = 0;
            cuentaVocales[1] = 0;
            cuentaVocales[2] = 0;
            cuentaVocales[3] = 0;
            cuentaVocales[4] = 0;

            palabra = a[i];
            k = 0;
            for (int j = 0; j < palabra.length(); j++)
            {
                for (k = 0; k < vocales.length(); k++)
                {
                    if (palabra.charAt(j) == vocales.charAt(k))
                    {
                        cuentaVocales[k] += 1;
                    }
                }
            }

            //Comprobar que dentro del array cuentaVocales no existan dos posiciones con mas de 2 en el contador de su elemento
            // {0,0,0,0,0}  {1,1,1,1,1}  {2,1,1,1,1} {2,2,1,1,1} ...  la primera y la última no valdrían porque se entiende que
            //no hay cuatro vocales distintas
            contador = SumaUnoContador(contador, cuentaVocales);
        }
        return contador;
    }

    public static String CifradoMilitar(String cadena)
    {
        String copia = cadena.toUpperCase();
        int i;
        //int ascii = (int)caracter;     //HOLAZ
        int ascii;
        char conver;

        StringBuilder sb = new StringBuilder(copia);
        for (i = 0; i < sb.length(); i++)
        {

            if (Character.isDigit(sb.charAt(i)))
            {
                if (sb.charAt(i) == '9')
                {
                    sb.setCharAt(i, '0');
                } else
                {
                    ascii = (int) sb.charAt(i);
                    ascii++;
                    conver = (char) ascii;


                    sb.setCharAt(i, conver);
                }
            } else
            {
                if (sb.charAt(i) == 'Z')
                {
                    sb.setCharAt(i, 'A');
                } else
                {
                    ascii = (int) sb.charAt(i);
                    ascii++;
                    conver = (char) ascii;


                    sb.setCharAt(i, conver);
                }
            }
        }
        return new String(sb);
    }

    public static String MarcaSubcadena(String cadena, String subcadena)
    {
        //String resultado;
        StringBuilder sb = new StringBuilder(cadena);
        String cacho;
        int i;

        for (i = 0; i < sb.length() - subcadena.length() + 1; i++)
        {
            cacho = sb.substring(i, i + subcadena.length());

            if (cacho.equals(subcadena))
            {
                sb.setCharAt(i, '*');
            }
        }
        return new String(sb);
    }

    public static void EscribeNombres(String cadena)
    {
        String[] a = cadena.split(" ");
        int i;
        int vueltas = a.length / 3;

        for (i = 0; i < vueltas; i++)
        {
            System.out.print(a[2] + " " + a[0] + " " + a[1]);
            System.out.println();
        }

    }

    public static int[] CuentaLetras(String cadena)
    {
        String letras = "abcde";
        int[] array = new int[5];
        int i, j;

        for (i = 0; i < letras.length(); i++)
        {
            for (j = 0; j < cadena.length(); j++)
            {
                if (letras.charAt(i) == cadena.charAt(j))
                {
                    array[i]++;
                }
            }
        }
        return array;
    }

    public static String MayusculasMinusculas(String cadena, int n)
    {
        String resultado = "";

        switch (n)
        {
            case 1:
            {
                //Todas a minúscula
                resultado = cadena.toLowerCase();
            }
            break;

            case 2:
            {
                //Todas a mayúscula
                resultado = cadena.toUpperCase();
            }
            break;

            case 3:
            {
                //Primera letra de cada palabra a mayúscula...resto en minúscula
                String[] copia = cadena.toLowerCase().replace("\n", " ").split(" ");
                String palabra = "";
                String cadenaAux = "";
                int i;

                for (i = 0; i < copia.length; i++)
                {
                    palabra = copia[i];
                    cadenaAux = palabra.substring(0, 1).toUpperCase() + palabra.substring(1);
                    copia[i] = palabra;
                    resultado += cadenaAux + " ";
                }
            }
            break;

            case 4:
            {
                String[] copia = cadena.toLowerCase().replace("\n", "").split("\\.");
                String frase = "";
                String cadenaAux = "";
                int i;

                for (i = 0; i < copia.length; i++)
                {
                    frase = copia[i];
                    cadenaAux = frase.substring(0, 1).toUpperCase() + frase.substring(1);
                    copia[i] = frase;
                    resultado += cadenaAux + ". ";
                }

            }
            break;
        }
        return resultado;
    }

    public static String EliminaTag(String cadena)
    {
        String copia = "";
        int i;

        for (i = 0; i < cadena.length(); i++)
        {
            if (cadena.charAt(i) == '<')
            {
                while (cadena.charAt(i) != '>')
                {
                    i++;
                }
            } else
            {
                copia = copia + cadena.charAt(i);
            }
        }
        return copia;
    }

    public static String OrdenaPalabrasComa(String cadena)
    {
        String[] array = cadena.split(",");
        Arrays.sort(array);
        String copia = "";
        int i;

        for (i = 0; i < array.length; i++)
        {
            copia = copia + array[i];
        }
        copia = String.join(",", array);
        return copia;
    }

    public static String AcentosHTML(String cadena)
    {
        String signo = "<>&\"áÁéÉíÍóÓúÚñÑüÜ";
        String[] mnemo = {"&lt;", "&gt;", "&amp;", "&quot;", "&aacute;", "&Aacute;", "&aecute;", "&Eacute;", "&iacute;", "&Iacute;", "&oacute;", "&Oacute;", "&uacute;", "&Uacute;"
                , "&ntilde;", "&Ntilde;", "&uuml;", "&Uuml;"};
        StringBuilder sb = new StringBuilder(cadena);
        int i, j;

        for (i = 0; i < sb.length(); i++)
        {
            for (j = 0; j < signo.length(); j++)
            {
                if (sb.charAt(i) == signo.charAt(j))
                {
                    sb.delete(i, i + 1);  //**PREGUNTAR i+1 POR QUÉ ???
                    sb.insert(i, mnemo[j]);
                }
            }
        }
        return new String(sb);
    }

    public static String QuitaAcentos(String cadena)
    {
        String copia = "";
        String con = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
        String sin = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
        int i, j;

        StringBuilder sb = new StringBuilder(cadena);

        for (i = 0; i < sb.length(); i++)
        {
            for (j = 0; j < con.length(); j++)
            {
                if (sb.charAt(i) == con.charAt(j))
                {
                    sb.setCharAt(i, sin.charAt(j));
                }
            }
        }
        return new String(sb);
    }

    public static void EscribeArrayString(String[] a)
    {
        int i;
        System.out.print("[");
        for (i = 0; i < a.length - 1; i++)
        {
            System.out.print(a[i] + ",");
        }
        System.out.print(a[a.length - 1] + "]");
    }

    public static String[] PalabrasMismaLetra(String cadena)
    {
        String[] array = QuitaAcentos(cadena).toLowerCase().split(" ");
        String palabra;
        String[] copiaArray = new String[array.length];
        String[] resultado;
        int i, j, k;

        k = 0;
        for (i = 0; i < array.length; i++)
        {
            palabra = array[i];
            if (palabra.charAt(0) == palabra.charAt(palabra.length() - 1))
            {
                copiaArray[k] = array[i];
                k++;
            }
        }

        resultado = new String[k];
        for (i = 0; i < resultado.length; i++)
        {
            resultado[i] = copiaArray[i];
        }
        return resultado;
    }

    public static String NumeroTexto9(int n)
    {
        String texto = "";

        switch (n)
        {
            case 0:
                texto = "cero";
                break;
            case 1:
                texto = "uno";
                break;
            case 2:
                texto = "dos";
                break;
            case 3:
                texto = "tres";
                break;
            case 4:
                texto = "cuatro";
                break;
            case 5:
                texto = "cinco";
                break;
            case 6:
                texto = "seis";
                break;
            case 7:
                texto = "siete";
                break;
            case 8:
                texto = "ocho";
                break;
            case 9:
                texto = "nueve";
                break;
            default:
                break;
        }
        return texto;
    }

    public static String NumeroTexto99(int n)
    {
        String texto = "";
        int decena = n / 10;
        int unidad = n % 10;

        switch (decena)
        {
            case 0:
                texto = NumeroTexto9(unidad);
                break;
            case 1:
                switch (n)
                {
                    case 10:
                        texto = "diez";
                        break;
                    case 11:
                        texto = "once";
                        break;
                    case 12:
                        texto = "trece";
                        break;
                    case 14:
                        texto = "catorce";
                        break;
                    case 15:
                        texto = "quince";
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        texto = "dieci" + NumeroTexto9(n);
                }
                break;

            case 2:
                switch (unidad)
                {
                    case 0:
                        texto = "veinte";
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        texto = "veinti" + NumeroTexto9(unidad);
                }
                break;

            case 3:
                switch (unidad)
                {
                    case 0:
                        texto = "treinta";
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        texto = "treinta y " + NumeroTexto9(unidad);

                }
                break;

            case 4:
                switch (unidad)
                {
                    case 0:
                        texto = "cuarenta";
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        texto = "cuarenta y " + NumeroTexto9(unidad);

                }
                break;

            case 5:
                switch (unidad)
                {
                    case 0:
                        texto = "cincuenta";
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        texto = "cincuenta y " + NumeroTexto9(unidad);

                }
                break;

            case 6:
                switch (unidad)
                {
                    case 0:
                        texto = "sesenta";
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        texto = "sesenta y " + NumeroTexto9(unidad);

                }
                break;

            case 7:
                switch (unidad)
                {
                    case 0:
                        texto = "setenta";
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        texto = "setenta y " + NumeroTexto9(unidad);

                }
                break;

            case 8:
                switch (unidad)
                {
                    case 0:
                        texto = "ochenta";
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        texto = "ochenta y " + NumeroTexto9(unidad);

                }
                break;

            case 9:
                switch (unidad)
                {
                    case 0:
                        texto = "noventa";
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        texto = "noventa y " + NumeroTexto9(unidad);

                }
                break;
        }
        return texto;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("========================");
        System.out.println("MENÚ CADENAS TIPO EXAMEN");
        System.out.println("========================");
        System.out.println("[1] PalabraMayorLongitud");
        System.out.println("[2] NumeroTelefonico");
        System.out.println("[3] IntercalaCadenas");
        System.out.println("[4] LetrasNoAparecen");
        System.out.println("[5] PorcentajePalabras");
        System.out.println("[6] VisualizaPalabras");
        System.out.println("[7] FrecuenciaVocales");
        System.out.println("[8] CuatroVocales");   //**Mirar función anexa a este ejercicio (SumaUnoContador)
        System.out.println("[9] CifradoMilitar");
        System.out.println("[10] MarcaSubcadena");
        System.out.println("[11] EscribeNombres");
        System.out.println("[12] CuentaLetras");
        System.out.println("[13] MayusculasMinusculas");
        System.out.println("[14] EliminaTag");
        System.out.println("[15] OrdenaPalabrasComa");
        System.out.println("[16] AcentosHTML");
        System.out.println("[17] PalabrasMismaLetra");
        System.out.println("[18] NumerosTexto99");
        System.out.println("[19] QuitaAcentos");
        System.out.println();
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();

        switch (opcion)
        {
            case 1:
            {
                //Leer una frase y encontrar la palabra de mayor longitud. El programa debe imprimir
                //la palabra con el número de caracteres de la misma.

                String cadena = "Si los ves que no lo berengena no le na que es pa na";
                String mayor;

                System.out.println(cadena);
                mayor = PalabraMayorLongitud(cadena);
                System.out.println(mayor + " = " + mayor.length());

            }
            break;

            case 2:
            {
                //Ingresar un número telefónico en formato de cadena y luego lo convierta de la siguiente manera:
                //            Número Telefónico: 5256284000
                //            Nueva Cadena: (52)-5-6284000

                String copia;
                String cadena = "5256284000";
                System.out.println(cadena);
                copia = NumeroTelefonico(cadena);
                System.out.println(copia);

            }
            break;

            case 3:
            {
                //Hacer un programa que al recibir como datos dos cadenas de caracteres
                //forme una tercera cadena intercalando los caracteres de las palabras de las cadenas recibidas.

                String cadena = "Primera frase";
                String cadena2 = "Segunda castaña de oracion";
                String copia;

                System.out.println(cadena);
                System.out.println(cadena2);
                copia = IntercalaCadenas(cadena, cadena2);
                System.out.println(copia);
            }
            break;

            case 4:
            {
                //Pasaremos una cadena por parámetro y devolveremos una cadena
                //con las letras del abecedario que no aparecen en la cadena.


                String cadena = "El día del partidazo";
                String copia;

                System.out.println(cadena);
                copia = LetrasNoAparecen(cadena);
                System.out.println(copia);
            }
            break;

            case 5:
            {
                //Ingrese un texto e indique el porcentaje de palabras que tiene menos de 5 caracteres
                //y el porcentaje de palabras con 5 o más caracteres.
                String cadena = "La casa de la abuela empezando muerdago y noticias sin tak";
                System.out.println(cadena);
                int n = PorcentajePalabras(cadena);
                System.out.println("Porcetnaje menor = " + n + "%" + "\nPorcentaje mayor = " + (100 - n) + "%");
            }
            break;

            case 6:
            {
                //Escriba un programa que lea una frase y a continuación visualice cada palabra de la frase en columnas,
                //seguida del número de letras que tiene cada palabra.
                String cadena = "Hola don Pepito hola don Jose";
                System.out.println(cadena);
                VisualizaPalabras(cadena);

            }
            break;

            case 7:
            {
                //Escriba un programa que calcule la frecuencia de aparición de las vocales
                //de un texto porcionado por el usuario. Esta solución se debe presentar en forma de histograma,
                // por ejmplo:
                //             a   15     ***************
                //             e    8     ********

                String cadena = "En la granja de Pepito habia tostadas y burritos";
                System.out.println(cadena);
                System.out.println();
                FrecuenciaVocales(cadena);

            }
            break;

            case 8:
            {
                //Escribir un programa que cuente el número de palabras en un texto,
                //que tengan al menos cuatro vocales diferentes.

                String cadena = "El tocamilotuke no seca bien la ropatesusolis palitroque y escobilla";
                int contador;
                contador = CuatroVocales(cadena);
                System.out.println(contador);
            }
            break;

            case 9:
            {
                //Un grupo de inteligencia militar desea codificar los mensajes secretos de tal forma
                //que no puedan ser interpretados con una lectura directa, para lo cual han establecido las siguientes reglas:
                //a) Todo mensaje debe tener sus letras en mayúsculas
                //b) Reemplazar cada letra por la que sigue según abecedario, excepto Z que  se deberá reemplazar con la letra A.
                //c) reemplazar cada dígito encontrado por el siguiente numero excepto el 9 que  deberá ser reemplazado por el 0.

                String cadena = "Holaz do2n4 P1ep6it9o";
                String resultado;
                resultado = CifradoMilitar(cadena);

                System.out.println(cadena);
                System.out.println(resultado);
            }
            break;

            case 10:
            {
                // Escribe una función marcaSubCadena a la que le pasamos dos cadenas y nos busca la
                //segunda cadena dentro de la primera. Nos devolverá otra cadena igual que la primera,
                //pero en la que se cambiará la primera letra de cada vez que aparece la subcadena por
                //un asterisco.
                String cadena = "El gato se come la comida de otro gato";
                String subcadena = "com";
                String copia;

                System.out.println(cadena);
                copia = MarcaSubcadena(cadena, subcadena);
                System.out.println(copia);
            }
            break;

            case 11:
            {
                //Escribe la función escribeNombres a la que le pasamos una cadena por parámetro
                //y nos la escribe  por la pantalla (con  println) con el siguiente formato:  la cadena
                //contendrá  varias  palabras  separadas  por  espacios,  con  el  siguiente  formato:
                //“apellido1  apellido2  nombre  apellido1  apellido2  nombre  (…)”  y  deberemos
                //escribirla por pantalla de la siguiente forma:
                //nombre apellido1 apellido2
                //nombre apellido1 apellido2
                //(…)

                String cadena = "apellido1 apellido2 nombre apellido1 apellido2 nombre " +
                        "apellido1 apellido2 nombre apellido1 apellido2 nombre";
                EscribeNombres(cadena);
            }
            break;

            case 12:
            {
                // Escribe la función cuentaLetras a la que le pasas una cadena por parámetro y te
                //devuelve un array de  enteros. El tamaño del array será 5 y el contenido será el
                //número de veces que aparecen las letras “a”, “b”, “c”, “d” y “e”, respectivamente,
                //en la cadena que le hemos pasado (independientemente de si son mayúsculas o
                //minúsculas).
                //Ej.: cadena = “patata camaleón batata”, resultado: [8, 1, 1, 0, 1]
                //Versión  Pro:  La  función  devolverá  un  array  de  enteros  con  26  posiciones
                //correspondientes  a  las  26  letras  del  abecedario.  No  uséis  un  switch  (ni  26  ifs).
                //Perdón, 27, se me olvidaba la eñe.

                String cadena = "patata camaleón batata";
                int[] enteros;

                System.out.println(cadena);
                enteros = CuentaLetras(cadena);
                System.out.println(Arrays.toString(enteros));
            }
            break;

            case 13:
            {
                //Escribe la función mayusculasMinusculas que recibirá dos parámetros: una cadena
                //(que podrá contener saltos de línea) y un número entre 1 y 4. Dependiendo del
                //número que le pasemos, la función nos devolverá otra cadena con las siguientes
                //características:
                //•  1 = Todas las letras en minúsculas.
                //•  2 = Todas las letras en mayúsculas.
                //•  3 = La primera letra de cada palabra en mayúsculas y el resto en minúsculas.
                //•  4 = La primera letra de cada frase en mayúsculas y el resto en minúsculas.
                //Escribir  también  un  pequeño  menú  en  el  programa  principal  para  probar  las
                //diferentes opciones.

                String resultado;
                //String cadena = "EL COCHE DE CABALLOS.\nTENEMOS UNA PLAYA A QUINCE MINUTOS";
                String cadena = "el coche de caballos.\ntenemos una playa a quince minutos";
                int n;

                System.out.println("================");
                System.out.println("OPCIONES CADENAS");
                System.out.println("================");
                System.out.println("[1] Todas las letras en minúsculas");
                System.out.println("[2] Todas las letras en mayúsculas");
                System.out.println("[3] La primera letra de cada");
                System.out.println("[4] La primera letra de cada frase en mayúsculas y el resto en minúsculas");
                System.out.print("Elige un número ");
                n = sc.nextInt();

                System.out.println("CADENA ORIGINAL: ");
                System.out.println(cadena);
                System.out.println(">>>>>>>>>>><<<<<<<<<<");
                resultado = MayusculasMinusculas(cadena, n);
                System.out.println(resultado);
            }
            break;

            case 14:
            {
                //Escribe la función eliminaTags a la que le pasamos una cadena que contiene tags
                //(como los de XML) y los elimina dejando sólo el texto (nos devuelve una cadena con
                //el resultado).
                //Ej.: <p>Esto es texto normal <b>y esto es texto en negrita</b>.</p>
                //Nos devolvería: Esto es texto normal y esto es texto en negrita.

                String texto = "<p>Esto es texto normal <b>y esto es texto en negrita</b>.</p>";
                String copia;

                System.out.println(texto);
                copia = EliminaTag(texto);
                System.out.println(copia);
            }
            break;

            case 15:
            {
                //Escribe  la  función  ordenaPalabrasComas  a  la  que  le  pasamos  una  cadena  que
                //contiene varias palabras separadas por comas y nos devuelve otra cadena con las
                //mismas palabras separadas por comas, pero ordenadas en orden alfabético.
                //Ej.: “hola,don,pepito,pasó,usted,ya,por,casa”
                //Devolvería: “casa,don,hola,pasó,pepito,por,usted,ya”

                String cadena = "si,tambien,espera,noticia,lagarto,perdiz,loro,gato,perro";
                String copia;

                System.out.println(cadena);
                copia = OrdenaPalabrasComa(cadena);
                System.out.println(copia);

            }
            break;

            case 16:
            {
                //Escribe la función acentosHTML que te sustituye los caracteres acentuados que le
                //paséis  por  el  código  HTML  correspondiente.  La  función  recibirá  una  cadena  por
                //parámetro y nos devolverá otra cadena con el resultado. Aquí tenéis una tabla con
                //las equivalencias:
                //
                //signo  mnemo
                //
                //  signo     mnemo         signo   mnemo
                //  <         &lt;          Í       &Iacute;
                //  >         &gt;          ó       &oacute;
                //  &         &amp;         Ó       &Oacute;
                //  "         &quot;        ú       &uacute;
                //  á         &aacute;      Ú       &Uacute;
                //  Á         &Aacute;      ñ       &ntilde;
                //  é         &aecute;      Ñ       &Ntilde;
                //  É         &Eacute;      ü       &uuml;
                //  í         &iacute;      Ü       &Uuml;

                String cadena = "Camión árbol método <b> Ínca y murciélago ú Ü";
                String copia;

                System.out.println(cadena);
                copia = AcentosHTML(cadena);
                System.out.println(copia);

            }
            break;

            case 17:
            {
                //Escribe  la  función  palabrasMismaLetra  a  la  que  le  pasamos  una  cadena  y  nos
                //devolverá un array de cadenas que contendrá las palabras que empiezan y acaban
                //por la misma letra. A la hora de contar las palabras, habrá que ignorar los símbolos
                //de puntuación y las mayúsculas y minúsculas.
                //Ej.: “Amanda tiene tres serpientes.” devolvería {amanda, serpientes}

                String cadena = "Evade monté ovíedo lÄta amada";
                String[] array;

                System.out.println(cadena);
                array = PalabrasMismaLetra(cadena);
                EscribeArrayString(array);
            }
            break;

            case 18:
            {
                //Escribe una función numeroTexto99 a la que le pasamos un entero y nos devuelve
                //una cadena con ese número puesto como texto (p.ej.: 76 = “setenta y seis”).
                //-  El número deberá estar comprendido entre 0 y 99. En caso contrario, devuelve
                //una cadena vacía.
                //-  Se recomienda escribir la función NumeroTexto9 que hace lo mismo, pero sólo
                //con números de 1 cifra, y usarla para simplificar esta función.
                //-  Si me ponéis un switch de 100 elementos os echo de clase directamente.
                //-  Si no sabéis como se escriben los números del uno al noventa y nueve, os mando
                //de vuelta a la ESO.
                //-  OPCIONAL: Escribir la función NumeroTexto999.

                String cadena;
                int n;
                System.out.print("Escribe número: ");
                n = sc.nextInt();

                cadena = NumeroTexto99(n);
                System.out.println(cadena);


            }
            break;

            case 19:
            {
                //Quita los acentos de una cadena que pases por parámetro y devolverá la cadena sin los acentos

                String cadena = "Camión sillón úrgan ñoñas";
                String copia = "";

                System.out.println(cadena);
                copia = QuitaAcentos(cadena);
                System.out.println(copia);
            }
            break;

        }

    }
}

