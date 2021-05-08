package com.example.simplerestapis;

public class Award {
        private String category;
        private String name;
        private boolean winner;

        public Award(String category, String name, boolean winner)
        {
            this.category = category;
            this.name = name;
            this.winner = winner;
        }

        public String getCategory()
        {
            return category;
        }

        public void setCategory(String category){
            this.category = category;
        }

        public String getName()
        {
            return name;
        }

        public boolean isWinner()
        {
            return winner;
        }
}
