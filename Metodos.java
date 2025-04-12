import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.JOptionPane;


public class Metodos {

    static clsGenerales gen = new clsGenerales();

    public void Proceso() {

        LlenarColaPersona();

        gen.Mensaje("Programa finalizado");

    }
    
    public int ValidarOpersonaionMenuPersona(){

        try {

            int opt = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opción:\n\n1: Agregar persona\n2: Consultar persona\n3: Actualizar persona\n4: Eliminar persona\n5: Ver Personas sensadas\n6: Salir del programa"));

            if (opt >= 1 && opt <= 6) {

                return opt;
                
            }

            else {

                gen.Mensaje("Opersonaion no valida, intente de nuevo(1-6)");

                return ValidarOpersonaionMenuPersona();

            }
    
        } 
        
        catch (Exception e) {

            gen.Mensaje("Error, tipo de dato no válido. Por favor, ingrese un número entero(1-6)");
            return ValidarOpersonaionMenuPersona();

        }

    }

    public double ValidarAuxilio(String Desplazado, int Estrato, int Edad) {
        
        double Auxilio = 1300000 * 0.8;

        try {

            if (Desplazado.equalsIgnoreCase("si") && Estrato<=3 && Edad < 18) {

                gen.Mensaje("La persona cumple los requerimientos para el auxilio(Ser desplazado, menor de edad y estrato menor a 3)");

                return Auxilio;
                
            }

            else {

                gen.Mensaje("La persona no cumple los requerimientos para el auxilio(Ser desplazado, menor de edad y estrato menor a 3)");

                return 0;

            }
    
        } 
        
        catch (Exception e) {

            return ValidarAuxilio(Desplazado, Estrato, Edad);

        }
    
    }

    public void LlenarColaPersona() {

        Queue<ObjPersona> cola = new ArrayDeque<>();
        boolean continuar = true;
        String agregar = "";

        while (continuar) {

            ObjPersona o = new ObjPersona();
            o.setNombre(JOptionPane.showInputDialog("Ingrese el nombre: "));
            o.setCedula(gen.leerEnteroPos("Ingrese la cedula: "));

            int Edad = gen.leerEdad("Ingrese la edad: ");
            o.setEdad(Edad);

            String Desplazado = ValidarSiNo("¿La persona es desplazada?(Si/No)");
            o.setEsDesplazado(Desplazado);

            int Estrato = gen.leerEstrato_06("Ingrese el estrato(0-6): ");
            o.setEstrato(Estrato);


            /* Nota: Aca ingrese Desplazado y Estrato como variables, para poder hacer una validacion aparte para el auxilio, si es desplazado, menor de edad y es de estrato 3 o menor, recibira el auxilio del 80% del minimo */

            o.setAuxilio(ValidarAuxilio(Desplazado, Estrato, Edad));

            cola.offer(o);

            agregar = ValidarSiNo("¿Desea agregar más personas?(Si/No)");

            if (agregar.equalsIgnoreCase("No")) {

                continuar = false;

            }

        }

        MostrarColaPersona(cola);

        int opt;

        do {

            opt = ValidarOpersonaionMenuPersona();
            
            if (opt != 6) {

                cola = AccionesRegistroPersona(cola, opt);

                if (opt != 5) {

                    MostrarColaPersona(cola);

                }
                
            }

        }
        
        while (opt != 5);

        System.out.println("Programa finalizado");

    }

    public void MostrarColaPersona(Queue<ObjPersona> cola) {

        String TextoCola = "Cola de Objpersona: ";

        for (ObjPersona r : cola) {

            TextoCola += "\nNombre: " + r.getNombre() +
                        "\nCedula: " + r.getCedula() +
                        "\nEdad: " + r.getEdad() +
                        "\nAuxilio: " + r.getAuxilio() +
                        "\nDesplazado: " + r.getEsDesplazado() +
                        "\nEstrato: " + r.getEstrato() + "\n";

        }

        gen.Mensaje(TextoCola);

    }

    public Queue<ObjPersona> AccionesRegistroPersona(Queue<ObjPersona> cola, int opt) {

        Queue<ObjPersona> nuevaCola = new ArrayDeque<>();

        String Eliminar = "no";
        int Existe = 0;

        if (opt == 1) {

            ObjPersona o = new ObjPersona();
            o.setNombre(JOptionPane.showInputDialog("Ingrese el serial: "));
            o.setCedula(gen.leerEnteroPos("Ingrese la cedula: "));

            int Edad = gen.leerEdad("Ingrese la edad: ");
            o.setEdad(Edad);

            String Desplazado = ValidarSiNo("¿La persona es desplazada?(Si/No)");
            o.setEsDesplazado(Desplazado);

            int Estrato = gen.leerEstrato_06("Ingrese el estrato(0-6): ");
            o.setEstrato(Estrato);


            /* Nota: Aca ingrese Desplazado y Estrato como variables, para poder hacer una validacion aparte para el auxilio, si es desplazado, menor de edad y es de estrato 3 o menor, recibira el auxilio del 80% del minimo */

            o.setAuxilio(ValidarAuxilio(Desplazado, Estrato, Edad));

            cola.offer(o);

            return cola;

        }

        else if (opt == 5) {

            MostrarColaPersona(cola);

            return cola;

        }

        else {

            int dato = gen.leerEnteroPos("Ingrese la cedula de la persona: ");
            
            while (!cola.isEmpty()) {

                ObjPersona persona = cola.poll();

                if (persona.getCedula() == dato) {

                    Existe = 1;

                    switch (opt) {

                        case 2: 

                            gen.Mensaje("\nNombre: " + persona.getNombre() +
                                        "\nCedula: " + persona.getCedula() +
                                        "\nEdad: " + persona.getEdad() +
                                        "\nAuxilio: " + persona.getAuxilio() +
                                        "\nDesplazado: " + persona.getEsDesplazado() +
                                        "\nEstrato: " + persona.getEstrato() + "\n");
                            
                            break;

                        case 3:

                            int Edad = gen.leerEdad("Ingrese la nueva edad (Antes "+ persona.getEdad() + "): ");
                            persona.setEdad(Edad);
                
                            String Desplazado = ValidarSiNo("¿Es desplazado?(Antes "+ persona.getEsDesplazado() + "): ");
                            persona.setEsDesplazado(Desplazado);
                
                            int Estrato = gen.leerEstrato_06("Ingrese el nuevo estrato(0-6)(Antes: "+ persona.getEstrato() + "): ");
                            persona.setEstrato(Estrato);
                
                
                            /* Nota: Aca ingrese Desplazado y Estrato como variables, para poder hacer una validacion aparte para el auxilio, si es desplazado, menor de edad y es de estrato 3 o menor, recibira el auxilio del 80% del minimo */
                
                            persona.setAuxilio(ValidarAuxilio(Desplazado, Estrato, Edad));

                            break;

                        case 4:                           

                            Eliminar = ValidarSiNo("Persona a eliminar: " + 
                                                        "\nNombre: " + persona.getNombre() +
                                                        "\nCedula: " + persona.getCedula() +
                                                        "\nEdad: " + persona.getEdad() +
                                                        "\nAuxilio: " + persona.getAuxilio() +
                                                        "\nDesplazado: " + persona.getEsDesplazado() +
                                                        "\nEstrato: " + persona.getEstrato() + 
                                                        "\n¿Seguro que quiere eliminar este registro?(Si/No)");

                            if (Eliminar.equalsIgnoreCase("si")) {
                                
                                gen.Mensaje("El registro se ha eliminado");

                            }

                            break;

                    }

                }

                if (opt != 4 || Eliminar.equalsIgnoreCase("no")){

                    nuevaCola.offer(persona);

                    Eliminar = "no";

                }

                

            }

            if (Existe == 0) {

                gen.Mensaje("La cedula ingresada no está registrada en el sistema");
            }

            return nuevaCola;
            
        }
    
    }


    public String ValidarSiNo(String txt) {
        
        try {

            String disponible = JOptionPane.showInputDialog(txt);

            if (disponible.equalsIgnoreCase("si") || disponible.equalsIgnoreCase("no")) {

                return disponible;

            }

            else {

                gen.Mensaje("Error, ingrese Si/No");

                return ValidarSiNo(txt);

            }
            
        }
        
        catch (Exception e) {

            gen.Mensaje("Error, tipo de dato no válido. Por favor, ingrese Si/No");

            return ValidarSiNo(txt);

        }

    }

}
