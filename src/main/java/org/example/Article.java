package org.example;

public class Article {

        private String name;
        private UserStatus status;

        public Article(String name, UserStatus status) {
            this.name = name;
            this.status = status;
        }

//        public String getName() {
//            return name;
//        }

        public UserStatus getStatus() {
            return status;
        }

        public void setStatus(UserStatus status) {
            this.status = status;
        }


}
