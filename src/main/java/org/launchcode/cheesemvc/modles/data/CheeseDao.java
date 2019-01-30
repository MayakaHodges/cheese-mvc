package org.launchcode.cheesemvc.modles.data;

import org.launchcode.cheesemvc.modles.Cheese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CheeseDao extends CrudRepository<Cheese, Integer>
{

}
