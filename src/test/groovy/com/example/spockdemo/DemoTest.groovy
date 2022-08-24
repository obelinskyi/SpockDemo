package com.example.spockdemo

import com.example.spockdemo.dto.Person
import org.spockframework.spring.SpringBean

class DemoTest extends BaseSpringBootTest {

    public static final Person SHEVA = new Person('Taras', 'Shevchenko', 47, 'Poet')

    @SpringBean
    PersonDaoService personDaoService = Mock()

    def 'As a user I can get a Person by id'() {
        when:
        def responseEntity = get('/person', 1)

        then: 'Response code is OK'
        'Assert response code is Valid' responseEntity

        and: 'Body is present'
        responseEntity.getBody()

        and: 'Body has valid fields'
        with(responseEntity.getBody() as Person) {
            verifyAll {
                first() == SHEVA.first()
                last() == SHEVA.last()
                age() == SHEVA.age()
                profession() == 'Poet'
            }
        }

        and: 'There were 1 interactions with mock'
        1 * personDaoService.findById(_) >> SHEVA
    }
}
