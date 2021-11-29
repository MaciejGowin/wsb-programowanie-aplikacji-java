/*
 * Copyright (c) 2014 Ryanair Ltd. All rights reserved.
 */
package pl.wsb.programowaniejava.maciejgowin.przyklad.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AdultValidator implements ConstraintValidator<Adult, LocalDate> {

    @Override
    public void initialize(final Adult constraintAnnotation) {
    }

    @Override
    public boolean isValid(final LocalDate value, final ConstraintValidatorContext context) {
        return value != null && value.plusYears(18).minusDays(1).isBefore(LocalDate.now());
    }
}
