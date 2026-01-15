import  java.util.*;
public class Main {
    Scanner sc = new Scanner(System.in);
    Map<String, Map<String, String>> especies = new HashMap<>();

    public void Reporte() {
        System.out.println("==== Reporte de Animales ====");

        for (Map.Entry<String, Map<String, String>> especieEntry : especies.entrySet()) {
            String especie = especieEntry.getKey();
            Map<String, String> animales = especieEntry.getValue();

            for (Map.Entry<String, String> animalEntry : animales.entrySet()) {
                    System.out.println(
                            "Especie: " + especie + " | Animal: " + animalEntry.getKey() + " | Estado: " + animalEntry.getValue());
         } }

        long disponibles = especies.values().stream()
                .flatMap(animales -> animales.entrySet().stream())
                .filter(entry -> entry.getValue().equalsIgnoreCase("Disponible"))
                .count();

        long adoptados = especies.values().stream()
                .flatMap(animales -> animales.entrySet().stream())
                .filter(entry -> entry.getValue().equalsIgnoreCase("Adoptado"))
                .count();

        long total =  disponibles + adoptados;

        System.out.println("Total de animales: " + total + "|| Diponibles: " + disponibles + "|| Adoptados: " + adoptados);

    }


    public void animalesAdoptados() {
        System.out.println("==== Animales Adoptados ====");

        for (Map.Entry<String, Map<String, String>> especieEntry : especies.entrySet()) {
            String especie = especieEntry.getKey();
            Map<String, String> animales = especieEntry.getValue();

            for (Map.Entry<String, String> animalEntry : animales.entrySet()) {
                if (animalEntry.getValue().equalsIgnoreCase("Adoptado")) {
                    System.out.println(
                            "Especie: " + especie + " | Animal: " + animalEntry.getKey()
                    );
                }else{
                    System.out.println("No hay animales adoptados");
                }
            }
        }
    }


    public void animalesDisponibles() {
        System.out.println("==== Animales Disponibles ====");

        for (Map.Entry<String, Map<String, String>> especieEntry : especies.entrySet()) {
            String especie = especieEntry.getKey();
            Map<String, String> animales = especieEntry.getValue();

            for (Map.Entry<String, String> animalEntry : animales.entrySet()) {
                if (animalEntry.getValue().equalsIgnoreCase("Disponible")) {
                    System.out.println(
                            "Especie: " + especie +
                                    " | Animal: " + animalEntry.getKey()
                    );
                } else if (animalEntry.getValue().equalsIgnoreCase(null)) {
                    System.out.println("No hay animales Disponibles");
                }
            }
        }
    }

public String marcarAdoptado(){
    System.out.println("==== Marcar Adoptado ====");
    System.out.println("Escriba el nombre de la especie");
    String especie = sc.nextLine().toLowerCase();
    System.out.println("Escriba el nombre del animal");
    String animal = sc.nextLine().toLowerCase();

    if(especies.containsKey(especie)) {
        if (especies.get(especie).containsKey(animal)) {
            especies.get(especie).put(animal, "Adoptado");
            return "Estado cambiado";
        } else {
            return "El animal no existe";
        }
    }else{
            return "Especie no encontrada";
    }


}

    public String registroEspecie() {
        System.out.println("==== Registro de Especies ====");
        System.out.println("Escriba el nombre de la especie");
        String nombreEspecie = sc.nextLine().toLowerCase();
        if (!especies.containsKey(nombreEspecie)) {
            especies.put(nombreEspecie, new HashMap<>());
            return "Especie registrada!!";
        }else {
            return "La especie ya existe";
        }
    }

    public String registroAnimal() {
        System.out.println("==== Registro Animal ====");
        System.out.println("Escriba el nombre del animal: ");
        String nombre = sc.nextLine();
        System.out.println("Escriba la especie de animal: ");
        String especie = sc.nextLine().toLowerCase();
       if (especies.containsKey(especie)) {
           especies.get(especie).put(nombre, "Disponible");
           return "Animal registrado!!";
       }else{
           return "La especie de animal no existe";

       }
    }

    public void menu(){
        int opcion = 0;
        do {
        System.out.println("=====| REFUGIO DE ANIMALES |=====");
            System.out.println("----- MENU -----");
            System.out.println("1. Registrar animal");
            System.out.println("2. Registrar especie");
            System.out.println("3. Marcar animal como adoptado");
            System.out.println("4. Mostrar todos los animales disponibles");
            System.out.println("5. Mostrar animales adoptados");
            System.out.println("6. Mostrar reporte general");
            System.out.println("7. Salir");
            System.out.println("Su opción:");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> registroAnimal();
                case 2 -> registroEspecie();
                case 3 -> marcarAdoptado();
                case 4 -> animalesDisponibles();
                case 5 -> animalesAdoptados();
                case 6 -> Reporte();
                case 7 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción incorrecta. Vuelva intentar");
                }

        }
        while(opcion!=7);
    }



    public static void main(String[] args) {
       new Main().menu();
        }
}
