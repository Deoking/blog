package io.deoki.blog.service;

import io.deoki.blog.entity.Role;
import io.deoki.blog.entity.Permission;
import io.deoki.blog.repository.PermissionRepository;
import io.deoki.blog.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class RoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleService.class);

    RoleRepository roles;
    PermissionRepository permissions;

    /**
     * Use the id to find one Role.
     * Returns null in case the Role does not exist
     * @param id
     * @return role
     */
    public Role findRoleById(Long id){
        return roles.findById(id).orElse(null);
    }

    /**
     * Finds all existing Role(s).
     */
    public List<Role> findRoleAll(){
        return roles.findAll();
    }

    /**
     * Use the id to find one Permission.
     * Returns null in case the Permission does not exist
     * @param id
     * @return permission
     */
    public Permission findPermissionById(Long id){
        return permissions.findById(id).orElse(null);
    }

    /**
     * Finds all existing Permission(s).
     */
    public List<Permission> findPermissionAll(){
        return permissions.findAll();
    }

    /**
     * Use the Role entity to save or update one Role.
     * @param role
     * @return savedRole
    */
    @Transactional
    public Role saveRole(Role role){
        logger.debug("Create Role named '{}' ....", role.getName());

        Role savedRole = roles.save(role);

        logger.debug("Successfully created the '{}'", savedRole.getName());
        return savedRole;
    }

    /**
     * Use the Role list to save or update multiple Roles.
     * @param roleList
     * @return savedRoleList
     */
    @Transactional
    public List<Role> saveRoles(List<Role> roleList){
        logger.debug("Create the list of roles. - size :  '{}'", roleList.size());
        List<Role> savedRolelist = roles.saveAll(roleList);

        savedRolelist.forEach(role -> {
            logger.debug("Successfully created the '{}'", role.getName());
        });

        return savedRolelist;
    }

    /**
     * Use the Permission entity to save or update one Permission.
     * @param permission
     * @return savedPermision
     */
    public Permission savePermission(Permission permission){
        logger.debug("Create Permission named '{}' ....", permission.getName());

        Permission savedPermision = permissions.save(permission);

        logger.debug("Successfully created the '{}'", permission.getName());
        return savedPermision;
    }

    /**
     * Use the Permission list to save or update multiple Permissions.
     * @param permissionList
     * @return savedPermisions
     */
    public List<Permission> savePermissions(List<Permission> permissionList){
        logger.debug("Create the list of permissions. - size :  '{}'", permissionList.size());
        List<Permission> savedPermisions = permissions.saveAll(permissionList);

        savedPermisions.forEach(permission -> {
            logger.debug("Successfully created the '{}'", permission.getName());
        });

        return savedPermisions;
    }

    /**
     * Use the one Role and Permission array to save or update one role.
     * @param role
     * @param permissionArray
     * @return savedRole
     */
    @Transactional
    public Role saveRoleWithPermission(Role role, Permission... permissionArray) {
        logger.debug("Create Role named '{}' ....", role.getName());

        Set<Permission> permissionSet = new HashSet<Permission>();

        for (Permission permission : permissionArray){
            logger.debug("'{}' has '{}' permissions.", role.getName(), permission.getName());
            permissionSet.add(permission);
        }

        role.setPermissions(permissionSet);

        logger.debug("Successfully created the '{}'", role.getName());
        return roles.save(role);
    }

    /**
     * Delete one Role using the Role entity.
     * @param role
     */
    @Transactional
    public void deleteRole (Role role){
        logger.debug("Delete role by Entity. -  selected role ID: {}, name : {}", role.getId(), role.getName());
        roles.delete(role);
    }

    /**
     * Delete one Role using the role ID.
     * @param roleId
     */
    @Transactional
    public void deleteRoleById (Long roleId){
        logger.debug("Delete role by ID. -  selected role ID: {}", roleId);
        roles.deleteById(roleId);
    }

    /**
     * Delete multiple Role using the role entity list.
     * @param deletedRoles
     */
    @Transactional
    public void deleteRoles (Iterable<Role> deletedRoles){
        int deleteCount = 0;

        for (Role role : deletedRoles){
            logger.debug("Delete selected roles. -  selected roled ID: {}, name : {}", role.getId(), role.getName());
            deleteCount++;
        }

        logger.debug("role count to delete : {}", deleteCount);

        roles.deleteAll(deletedRoles);
    }

    /**
     * Delete all Roles.
     */
    @Transactional
    public void deleteRoleAll (){
        logger.debug("Delete all roles. - role count to delete : {}", roles.count());
        roles.deleteAll();
    }

    /**
     * Delete one Permission using the Permission entity.
     * @param permission
     */
    public void deletePermission (Permission permission){
        logger.debug("Delete permission by Entity. -  selected permission ID: {}, name : {}", permission.getId(), permission.getName());
        permissions.delete(permission);
    }

    /**
     * Delete one Permission using the permission ID.
     * @param permissionId
     */
    public void deletePermissionById (Long permissionId){
        logger.debug("Delete permission by ID. -  selected permission ID: {}", permissionId);
        permissions.deleteById(permissionId);
    }

    /**
     * Delete multiple Permission using the permission entity list.
     * @param deletedPermissions
     */
    public void deletePermissions (Iterable<Permission> deletedPermissions){
        int deleteCount = 0;

        for (Permission permission : deletedPermissions){
            logger.debug("Delete selected permissions. -  selected permission ID: {}, name : {}", permission.getId(), permission.getName());
            deleteCount++;
        }

        logger.debug("permission count to delete : {}", deleteCount);

        permissions.deleteAll(deletedPermissions);
    }

    /**
     * Delete all Permissions.
     */
    public void deletePermissionAll (){
        logger.debug("Delete all permissions. - permission count to delete : {}", permissions.count());
        permissions.deleteAll();
    }

}
