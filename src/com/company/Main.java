package com.company;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
// отдельно без интерфейса пользователя всё работает не успел доделать интерфейс для пользователя
    //где  то точно ошибка

    public static void main(String[] args) throws IOException {
        List<Movie> movies = JsonReader.getMovies();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Чтобы вывести коллекцию фильмов нажмите 1");
            System.out.println("Нажмите 2 чтоб искать фильм по полному или частичному совпадению в названии");
            System.out.println("Нажмите на 3 чтоб остортировать по году выпуска");
            System.out.println("Нажмите на 4 чтоб остортировать по названию");
            System.out.println("Нажмите на 5 чтоб остортировать по режисеру");
            System.out.println("Нажмите на 6 чтоб найти фильмы где снимался тот или иной актер");
            System.out.println("Нажмите на 7 чтоб найти фильмы которые режисировал тот или иной режисёр");
            System.out.println("Нажмите на 8 чтоб найти фильмы вышедшие в определённом году");
            System.out.println("Нажмите на 9 чтоб узнать какую роль сыграл тот или иной актер в фильме где он снялся");
            System.out.println("Нажмите 10 чтобы выйти");
            Integer b = scanner.nextInt();
            if (b == 1) {
                for (Movie m : movies) {
                    System.out.println(m.getName());
                }
                System.out.println("       ");



            } else if (b == 2) {
//Примерный поиск
                System.out.println("Введите символ который есть в названии фильма, или примерное название");
                String vod = scanner.nextLine();
                for (Movie m : movies) {
                    if (m.getName().indexOf(vod) != -1) {
                        System.out.println(m.getName());
                    }
                }
                System.out.println("       ");

            } else if (b == 3) {
                // сортировка по году
                List<Movie> sortByYear = new ArrayList<>(movies);
                sortByYear.sort(Comparator.comparingInt(Movie::getYear));
                for (Movie m2 : sortByYear) {
                    System.out.printf("%s - %s\n", m2.getYear(), m2.getName());
                }
                System.out.println("       ");

            } else if (b == 4) {
                //сортировка по названию
                List<Movie> sortByName = new ArrayList<>(movies);
                sortByName.sort(Comparator.comparing(Movie::getName));
                for (Movie m1 : sortByName) {
                    System.out.printf(m1.getName());
                }
                System.out.println("       ");

            } else if (b == 5) {
                //сортировка по режисеру
                List<Movie> sortByDir = new ArrayList<>(movies);
                sortByDir.sort(Comparator.comparing(Movie::getDirectorName));
                for (Movie m : sortByDir) {
                    System.out.printf("%s - %s\n", m.getDirectorName(), m.getName());
                }
                System.out.println("       ");

            } else if (b == 6) {
                //поиск Всех фильмов, в который снимался тот или иной актёр. Критерий поиска "имя актера"
                System.out.println("Введите имя Актера");
                String h = scanner.nextLine();
                Map<String, String> sortByActor = new HashMap<>();
                for (Movie m : movies) {
                    for (Cast c : m.getCast()) {
                        if (h.equals(c.getFullName())) {
                            sortByActor.put(m.getName(), m.getCastName());
                        }
                    }
                }
                String gmt = "Movie name : %s, Actor name : %s";
                for (Map.Entry<String, String> kv : sortByActor.entrySet()) {
                    String msg = String.format(gmt, kv.getKey(), kv.getValue());
                    System.out.println(msg);
                }

                System.out.println("       ");

            } else if (b == 7) {
                //поиск Всех фильмов, которые режиссировал тот или иной режиссер. Критерий поиска "имя режиссера"
                System.out.println("Введите имя режисёра");
                String h = scanner.nextLine();
                Map<String, String> sortByDirector = new HashMap<>();
                for (Movie m : movies) {
                    if (h.equals(m.getDirectorName())) {
                        sortByDirector.put(m.getName(), m.getDirectorName());
                    }
                }
                String gmt = "Name Director : %s, Movie: %s";
                for (Map.Entry<String, String> kv : sortByDirector.entrySet()) {
                    String msg = String.format(gmt, kv.getValue(), kv.getKey());
                    System.out.println(msg);
                }
                System.out.println("       ");

            } else if (b == 8) {
                //поиск Всех фильмов, которые были выпущены в определенном году. Критерий поиска "год выпуска фильма"
                System.out.println("Введите год выхода фильма");
                Integer h = scanner.nextInt();
                Map<String, Integer> sortByYear = new HashMap<>();
                for (Movie m : movies) {
                    if (h.equals(m.getYear())) {
                        sortByYear.put(m.getName(), m.getYear());
                    }
                }
                String gmt = "Movie name : %s, year : %s";
                for (Map.Entry<String, Integer> kv : sortByYear.entrySet()) {
                    String msg = String.format(gmt, kv.getKey(), kv.getValue());
                    System.out.println(msg);
                }
                System.out.println("       ");

            } else if (b == 9) {
                // поиск Списка фильмов и роль того или иного актера в этом фильме. Критерий поиска "имя актера"
                System.out.println("Введите имя Актера");
                String h = scanner.nextLine();
                Map<String, String> sortByActor = new HashMap<>();
                for (Movie m : movies) {
                    for (Cast c : m.getCast()) {
                        if (h.equals(c.getFullName())) {
                            sortByActor.put(m.getName(), c.getRole());
                        }
                    }
                }
                String gmt = "Movie name : %s, Actor role : %s";
                for (Map.Entry<String, String> kv : sortByActor.entrySet()) {
                    String msg = String.format(gmt, kv.getKey(), kv.getValue());
                    System.out.println(msg);
                }
                System.out.println("       ");

            }else if (b==10){
                break;
            }

        }
    }
}



















//        Set<String> actors = new HashSet<>();
//        for (Movie m : movies){
//            for (Cast c: m.getCast()) {
//                actors.add(c.getFullName());
//            }
//        }
//        for (int i = 0;i <= actors.size();i++)
//        for (Movie m : movies){
//            for (Cast c: m.getCast()) {
//                if (actors.equals(c.getFullName())){
//                    System.out.println(c.getFullName());
//                    System.out.println(c.getRole());
//                }
//            }
//        }
//
///
//
//
//
//
//
//
//
//
//
//    }
//
