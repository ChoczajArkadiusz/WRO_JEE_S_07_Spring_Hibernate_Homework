package pl.coderslab.spring.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.util.Collection;

public class CollectionMaxSizeValidator implements ConstraintValidator<MaxSize, Collection> {
    private int max;

    public void initialize(MaxSize constraint) {
        this.max = constraint.max();
    }

    public boolean isValid(Collection collection, ConstraintValidatorContext context) {
        if (collection == null) {
            return true;
        }
        return collection.size() < max;
    }
}
