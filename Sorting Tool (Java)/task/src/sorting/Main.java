package sorting;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(final String[] args)  {
        Scanner scanner = new Scanner(System.in);
        String sortingType = "natural";
        String dataType="word";

        String inputFilePath;
        String outputFilePath;
        Integer totalNumbers=0;
        List<String> possibleArgument=List.of("-dataType","-sortingType","-inputFile","-outputFile");
        for (int i = args.length - 1; i >= 0; i--) {
            if (Objects.equals(args[i], "-sortingType")) {
                try {
                    if (Objects.equals(args[i + 1], "byCount") || Objects.equals(args[i + 1], "natural"))
                        sortingType = args[i + 1];
                }catch (Exception e ){
                    System.out.println("No sorting type defined");
                }
            }else if (Objects.equals(args[i], "-dataType")) {
                try {
                    if (Objects.equals(args[i + 1], "word") || Objects.equals(args[i + 1], "line") || Objects.equals(args[i + 1], "long"))
                        dataType = args[i + 1];
                } catch (Exception e) {
                    System.out.println("No data type defined!");
                }
            } else if (args[i] != null && !possibleArgument.contains(args[i]) && args[i].startsWith("-")) {

            System.out.println(args[i]+" is not a valid parameter. It will be skipped.");
            } else if (Objects.equals(args[i], "-inputFile")) {
                inputFilePath=args[i+1];
                try {
                    scanner=new Scanner(Path.of(inputFilePath));
                } catch (IOException e) {
                    System.out.println("no such input file");
                }
            } else if (Objects.equals(args[i], "-outputFile")) {
                outputFilePath=args[i+1];
                File file= new File(outputFilePath);
                PrintStream out = null;
                try {
                    out = new PrintStream(new FileOutputStream(outputFilePath));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                System.setOut(out);

            }


        }
        List<element> elementList=new ArrayList<>();
        if (Objects.equals(sortingType, "byCount")) {
            switch (dataType) {
                case "long" -> {

                    while (scanner.hasNext()) {
                        try {
                            element<Long> element = new element<>(scanner.nextLong(), sortingType, dataType);
                            totalNumbers = addElementToListSortedByCount(elementList, totalNumbers, element);
                        }catch (Exception e) {
                            System.out.println(scanner.next()+" is not a long. It will be skipped.");
                        }


                    }

                }
                case "line" -> {
                    while (scanner.hasNextLine()) {
                        element<String> element = new element<>(scanner.nextLine(), sortingType, dataType);
                        totalNumbers = addElementToListSortedByCount(elementList, totalNumbers, element);
                    }
                }
                default -> {
                    while (scanner.hasNext()) {
                        element<String> element = new element<>(scanner.next(), sortingType, dataType);
                        totalNumbers = addElementToListSortedByCount(elementList, totalNumbers, element);
                    }
                }

            }
            elementList.sort(new Comparatorelements());
            Set<element> setOfElement=new LinkedHashSet<>(elementList);
            int finalTotalNumbers = totalNumbers;
            System.out.println("Total numbers: "+finalTotalNumbers+".");
            setOfElement.forEach(x->{x.setPercentage(100L *x.getOccurences()/ finalTotalNumbers);
                System.out.println(x.getElemnt()+": "+x.getOccurences()+" time(s), "+x.getPercentage()+"%");
            });
        } else switch (dataType) {
            case "long" -> {
                while (scanner.hasNext()){
                    try {
                        element<Long> element=new element<>(scanner.nextLong(),sortingType,dataType);
                        totalNumbers = addElementToListSortedNaturally(elementList,totalNumbers,element);
                    } catch (Exception e) {
                        System.out.println(scanner.next()+" is not a long. It will be skipped.");
                    }
                }
                System.out.println("Total number: "+elementList.size());
                System.out.print("Sorted data: ");
                for (element e:elementList
                ) {
                    System.out.print(e.getElemnt()+" ");
                }
            }
            case "line" -> {
                while (scanner.hasNextLine()){
                    element<String> element=new element<>(scanner.nextLine(),sortingType,dataType);
                    totalNumbers = addElementToListSortedNaturally(elementList,totalNumbers,element);
                }
                System.out.println("Total line: "+elementList.size());
                System.out.println("Sorted data: ");
                for (element e:elementList
                ) {
                    System.out.println(e.getElemnt()+" ");
                }
            }
            default -> {
                while (scanner.hasNext()){
                    element<String> element=new element<>(scanner.next() ,sortingType ,dataType);
                    totalNumbers =  addElementToListSortedNaturally(elementList,totalNumbers,element);
                }
                System.out.println("Total word: "+elementList.size());
                System.out.print("Sorted data: ");
                for (element e:elementList
                ) {
                    System.out.print(e.getElemnt()+" ");
                }
            }
        }
    }
    public static int addElementToListSortedNaturally(List<element> elementList, Integer totalNumbers, element element){
        totalNumbers++;
        elementList.add(element);
        elementList.sort(Main.element::compareTo);
        return totalNumbers;
    }
    public static int addElementToListSortedByCount(List<element> elementList, Integer totalNumbers, element element) {
    Boolean newElement=true;
    totalNumbers++;
        if (elementList.size() > 0)
            for (int i = 0; i < elementList.size(); i++) {
                if (elementList.get(i).getElemnt().equals(element.getElemnt())) {
                    newElement = false;
                    elementList.get(i).setOccurences(elementList.get(i).getOccurences() + 1);
                    elementList.get(i).setPercentage(element.getOccurences() / totalNumbers);
                }
            }
        if (newElement) {
            elementList.add(element);
        }

        return totalNumbers;
    }
    static class element<T> implements Comparable<element>{
        T elemnt;
        int occurences=1;
        long percentage=0;
        String sortingType;
        String datatype;
        element(T elemnt,String sortingType,String datatype) {
            this.elemnt = elemnt;
            this.sortingType=sortingType;
            this.datatype=datatype;
        }

        @Override
        public int compareTo(@NotNull element element) {
            if (Objects.equals(datatype, "long"))
                return Long.compare((long)elemnt,(long)element.getElemnt());
            else return Objects.compare((String)elemnt, (String)element.getElemnt(), CharSequence::compare);
        }

        public T getElemnt() {
            return elemnt;
        }

        public void setElemnt(T elemnt) {
            this.elemnt = elemnt;
        }

        public int getOccurences() {
            return occurences;
        }

        public void setOccurences(int occurences) {
            this.occurences = occurences;
        }

        public long getPercentage() {
            return percentage;
        }

        public void setPercentage(long percentage) {
            this.percentage = percentage;
        }

        public String getSortingType() {
            return sortingType;
        }

        public void setSortingType(String sortingType) {
            this.sortingType = sortingType;
        }
    }
    static class Comparatorelements implements Comparator<element>{

        @Override
        public int compare(element element, element t1) {
            if (Objects.equals(element.getSortingType(), "byCount"))
                if (element.getOccurences()== t1.getOccurences())
                    return element.compareTo(t1);
                 else return Integer.compare(element.getOccurences(),t1.getOccurences());
            else  return element.compareTo(t1);
        }
    }

    private static class NoSortingTypeDefined extends Throwable {
        NoSortingTypeDefined(){
            System.out.println("No sorting type defined!");
        }
    }
}
