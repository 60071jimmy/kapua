/*******************************************************************************
 * Copyright (c) 2011, 2016 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *
 *******************************************************************************/
package org.eclipse.kapua.service.authorization.permission;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.eclipse.kapua.model.id.KapuaId;
import org.eclipse.kapua.model.id.KapuaIdAdapter;
import org.eclipse.kapua.service.authorization.access.AccessInfo;
import org.eclipse.kapua.service.authorization.domain.Domain;

/**
 * Permission definition.<br>
 * A permission can be associated to a {@link User} (using {@link AccessInfo} entity) or a {@link Domain}.<br>
 * Permissions enable the assignee to do {@link Actions} under specified domains and in specified scopes.
 * 
 * @since 1.0.0
 */
@XmlRootElement(name = "permission")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "domain",
        "action",
        "targetScopeId"
}, factoryClass = PermissionXmlRegistry.class, factoryMethod = "newPermission")
public interface Permission {

    /**
     * Sets the domain on which the {@link Permission} gives access.
     * 
     * @param domain
     *            The domain of the {@link Permission}.
     * @since 1.0.0
     */
    public void setDomain(String domain);

    /**
     * Gets the domain on which the {@link Permission} gives access.
     * 
     * @return The domain on which the {@link Permission} gives access.
     * @since 1.0.0
     */
    @XmlElement(name = "domain")
    public String getDomain();

    /**
     * Sets the {@link Actions} that this {@link Permission} allows to do on the domain.
     * 
     * @param action
     *            The {@link Action} that this {@link Permission} allows
     * @since 1.0.0
     */
    public void setAction(Actions action);

    /**
     * Gets the {@link Actions} that this {@link Permission} allows to do on the domain.
     * 
     * @return The {@link Actions} that this {@link Permission} allows.
     * @since 1.0.0
     */
    @XmlElement(name = "action")
    public Actions getAction();

    /**
     * Sets the target scope id that this {@link Permission} gives access.
     * 
     * @param targetScopeId
     *            The target scope id that this {@link Permission} gives access.
     * @since 1.0.0
     */
    public void setTargetScopeId(KapuaId targetScopeId);

    /**
     * Gets the target scope id that this {@link Permission} gives access.
     * 
     * @return The target scope id that this {@link Permission} gives access.
     * @since 1.0.0
     */
    @XmlElement(name = "targetScopeId")
    @XmlJavaTypeAdapter(KapuaIdAdapter.class)
    public KapuaId getTargetScopeId();
}
