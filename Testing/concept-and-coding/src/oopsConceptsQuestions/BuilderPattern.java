package oopsConceptsQuestions;

/*
The Builder Pattern is a creational design pattern that allows for the step-by-step construction of complex
objects. It follows key Object-Oriented Programming (OOP) principles by promoting encapsulation, abstraction,
separation of concerns, Flexible and Scalable Object Construction and immutability. Let’s break down how
the Builder Pattern adheres to core OOP principles.
 */

public class BuilderPattern {
    public static void main(String[] args) {
        House house = House.builder().setGarden(new Garden(0,0)).
                setPool(new Pool(0,0)).build();
    }
}

class House{
    private Pool pool;
    private Garden garden;

    private House(){

    }

    private void setPool(Pool pool){
        this.pool = pool;
    }

    private void setGarden(Garden garden){
        this.garden = garden;
    }

    public static HouseBuilder builder(){
        return new HouseBuilder();
    }

    static class HouseBuilder{
        private Pool pool;
        private Garden garden;

        public HouseBuilder setPool(Pool pool){
            this.pool = pool;
            return this;
        }

        public HouseBuilder setGarden(Garden garden){
            this.garden = garden;
            return this;
        }

        public HouseBuilder setGarden(int width,int length){
            this.garden = new Garden(width,length);
            return this;
        }

        public House build(){
            House house = new House();
            if(this.garden!=null){
                house.setGarden(this.garden);
            }
            if(this.pool!=null){
                house.setPool(this.pool);
            }
            return house;
        }
    }
}

class Pool{

    int width;
    int length;

    public Pool(int width,int length){
        this.length = length;
        this.width = width;
    }
}

class Garden{

    int width;
    int length;

    public Garden(int width,int length){
        this.length = length;
        this.width = width;
    }
}
