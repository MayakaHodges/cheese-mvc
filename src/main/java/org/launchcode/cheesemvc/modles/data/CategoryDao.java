package org.launchcode.cheesemvc.modles.data;

import org.launchcode.cheesemvc.modles.forms.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CategoryDao extends CrudRepository<Category, Integer>
{

}
