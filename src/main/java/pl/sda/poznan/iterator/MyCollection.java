package pl.sda.poznan.iterator;

public class MyCollection implements Iterable<String> {

    private int index = 0;
    private String[] elements = new String[10];

    public void addElement(String e) {
        if (index < elements.length) {
            elements[index++] = e;
        }
    }

    @Override //przy użyciu klasy anonimowej
    public Iterator<String> getIterator() {
        return new Iterator<String>() { //klasa anonimowa bez nazwy

            private int iteratorIndex = 0;

            @Override
            public String getNextElement() {
                if (!hasNextElement()) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                return elements[iteratorIndex++];
            }

            @Override
            public boolean hasNextElement() {

                if (iteratorIndex >= elements.length) {
                    return false;
                }
                String elem = elements[iteratorIndex];
                return elem != null;
            }
        };
    }

    //    @Override  // nowa klasa wewnętrzna
//    public Iterator<String> getIterator() {
//        return new MyCollectionIterator();
//    }


    private class MyCollectionIterator implements Iterator<String> {
        private int iteratorIndex = 0;

        @Override
        public String getNextElement() {
            if (!hasNextElement()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return elements[iteratorIndex++];
        }

        @Override
        public boolean hasNextElement() {

            //Jeęli doszliśmy do końca tablicy to nie ma kolejnego elementu
            if (iteratorIndex >= elements.length) {
                return false;
            }
            //Jezeli są elementy w kolekcji to pobieramy element
            String elem = elements[iteratorIndex];
            //zwracamy wynik opreacji czy element jest różny od null
            //jeżeli jest różny tzn żę mamy elemetn w kolekcji
            return elem != null;
        }
    }


}
