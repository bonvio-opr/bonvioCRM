package com.bonvio.staff.controller.generic;

import com.bonvio.staff.service.generic.interfaces.GenericService;
import com.bonvio.staff.settings.ResponseId;
import com.bonvio.staff.settings.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mil on 04.12.15.
 */

public class GenericController<T> {

    @Autowired
    public GenericService<T> tGenericService;

    private Class<T> tClass;

    @SuppressWarnings("unchecked")
    public GenericController() {
        tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public ResponseId getId(T t) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method[] allMethods = tClass.getDeclaredMethods();
        for (Method m : allMethods) {
            if (m.getName().equals("getId")) {
                return new ResponseId((Integer) tClass.getDeclaredMethod("getId", new Class[]{}).invoke(t, null));
            }
        }
        return new ResponseId((Integer) tClass.getSuperclass().getDeclaredMethod("getId", new Class[]{}).invoke(t, null));
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    @JsonView(Views.PublicView.class)
    public ResponseEntity<List<T>> getList(@RequestParam Integer userId) {
        List<T> tList;
        try {
            tList = tGenericService.getList();
            if (tList == null) {
                tList = new ArrayList<>();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(tList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @JsonView(Views.PublicView.class)
    public Object getById(@PathVariable Integer id, @RequestParam Integer userId) {
        return tGenericService.getById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(Views.PublicView.class)
    public Object save(@RequestBody T t, @RequestParam Integer userId) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        tGenericService.save(t);
        return getId(t);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @JsonView(Views.PublicView.class)
    public Object update(@RequestBody T t, @PathVariable Integer id, @RequestParam Integer userId) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException  {
        tGenericService.update(t);
        return getId(t);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    @JsonView(Views.PublicView.class)
    public Object deleteById(@PathVariable Integer id, @RequestParam Integer userId) {
        tGenericService.deleteById(id);
        return new ResponseId(null);
    }
}
