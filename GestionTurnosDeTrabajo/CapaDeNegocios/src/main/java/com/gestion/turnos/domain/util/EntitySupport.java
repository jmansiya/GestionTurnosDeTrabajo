package com.gestion.turnos.domain.util;

import java.lang.reflect.Field;

/**
 * Base class for entities.
 *
 */
public abstract class EntitySupport<T extends Entity, ID> implements Entity<T, ID> {

    private static Field identityField;

    public final boolean sameIdentityAs(final T other) {
        return other != null && this.identity().equals(other.identity());
    }

    public final ID identity() {
        if (identityField == null) {
            identityField = identityFieldLazyDetermination(this.getClass());
        }

        try {
            return (ID) identityField.get(this);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static Field identityFieldLazyDetermination(final Class cls) {
        Field identityField = null;

        for (Field field : cls.getDeclaredFields()) {
            if (field.getAnnotation(Identity.class) != null) {
                field.setAccessible(true);
                if (identityField != null) {
                    throw new IllegalStateException("Solo un campo puede ser anotado como " + Identity.class);
                } else {
                    identityField = field;
                }
            }
        }

        if (identityField == null) {
            if (cls == Object.class) {
                throw new IllegalStateException(
                  "Esta clase, o una de sus superclases, debe tener un camo unico anotado con: " + Identity.class);
            } else {
                return identityFieldLazyDetermination(cls.getSuperclass());
            }
        }

        return identityField;
    }

    @Override
    public final int hashCode() {
        return identity().hashCode();
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return sameIdentityAs((T) o);
    }

}
