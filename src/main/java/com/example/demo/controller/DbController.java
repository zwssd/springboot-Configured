package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/mydb")
public class DbController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getDbType(){
        String sql = "select * from test_user";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet( );
            if(entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        return list;
    }

    @RequestMapping("/user/{id}")
    public ModelAndView getUser(@PathVariable String id,Model model){
        Map<String,Object> map = null;

        List<Map<String, Object>> list = getDbType();

        for (Map<String, Object> dbmap : list) {
        	
            Set<String> set = dbmap.keySet();
            

            for (String key : set) {
                if(key.equals("id")){
            //System.out.println("dbmap.get(key)========="+dbmap.get(key).toString());
            //System.out.println("id========="+id);
                    if(dbmap.get(key).toString().equals(id)){
            System.out.println("id>>>>>========="+id);
                        map = dbmap;
                    }
                }
            }
        }

        if(map==null)
            map = list.get(1);
        
        model.addAttribute("title", "abcdeffffffffffzzzzzz");
        model.addAttribute("user", map);
        return new ModelAndView("user", "aa", model);
        //return map;
    }


}
