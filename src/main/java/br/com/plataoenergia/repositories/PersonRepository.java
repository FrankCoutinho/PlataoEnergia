package br.com.plataoenergia.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.plataoenergia.entities.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>
{
}
