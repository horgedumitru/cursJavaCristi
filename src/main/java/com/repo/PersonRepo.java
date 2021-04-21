package com.repo;

import com.model.Person;
import com.util.ConnectionManager;

import java.sql.*;

public class PersonRepo {

    private Connection connection;



    public PersonRepo(){
        connection = ConnectionManager.getConnectionManagerInstance().getConnection();
    }

    public boolean create (Person person){

        int valueQuery=0;
        String query = "INSERT INTO persons (name, email, dataAngajare, age) VALUES ( '"
                +person.getName()+
                "' , '"+person.getEmail()+
                "', '"+ person.getDataAngajare()+
                "', "+person.getAge()+
                ")";


        try {
            Statement st = connection.createStatement();
            valueQuery= st.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return valueQuery != 0;
    }


    public Person findByName (Person person){
        String queryRead = "SELECT name, email, dataAngajare, age FROM  persons WHERE name = ?";
        ResultSet rs = null;
        Person p = null;
        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement(queryRead);
            preparedStatement1.setString(1,person.getName());
             rs = preparedStatement1.executeQuery();

             if (rs != null){
                p= new Person();
                p.setName(rs.getString("name"));
                p.setEmail(rs.getString(2));
                p.setDataAngajare(rs.getDate(3));
                p.setAge(rs.getInt(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }


    public boolean updateByName (Person oldPerson, Person newPerson){

         boolean result = false;

        String queryUpdate = "UPDATE  persons SET name=?, email=?, dataAngajare=?, age=? WHERE name=?;";
        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement(queryUpdate);
            preparedStatement1.setString(1,newPerson.getName());
            preparedStatement1.setString(2,newPerson.getEmail());
            preparedStatement1.setDate(3,newPerson.getDataAngajare());
            preparedStatement1.setInt(4,newPerson.getAge());
            preparedStatement1.setString(5,oldPerson.getName());


            result =preparedStatement1.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
            return result;
    }


    public boolean  deleteByName (Person person){

        boolean result = false;

        String deleteQuery= "DELETE FROM  persons WHERE name=?";
        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement(deleteQuery);
            preparedStatement1.setString(1,person.getName());

            result =  preparedStatement1.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return result;
    }



}
