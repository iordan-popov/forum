package bg.swift.ip.forum.dao;

import bg.swift.ip.forum.entity.Entity;

public abstract class  EntityDAO {


    public abstract Entity findById(int id);


    public abstract Entity create(Entity entity);



}
