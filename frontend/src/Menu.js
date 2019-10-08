// in src/Menu.js
import React, { createElement } from 'react';
import { connect } from 'react-redux';
import { MenuItemLink, getResources } from 'react-admin';
import { withRouter } from 'react-router-dom';
import LabelIcon from '@material-ui/icons/Label';

//do not use resource in menu

const Menu = ({ resources, onMenuClick, logout }) => (
    <div>

        {resources.map(resource => (
            <MenuItemLink
                key={resource.name}
                to={`/${resource.name}`}
                primaryText={resource.options && resource.options.label || resource.name}
                leftIcon={createElement(resource.icon)}
                onClick={onMenuClick}
            />
        ))}
        <MenuItemLink
            to="/custom-route"
            primaryText="Miscellaneous"
            leftIcon={<LabelIcon />}
            onClick={onMenuClick} />
    </div>
);

const mapStateToProps = state => ({
    resources: getResources(state),
});

export default withRouter(connect(mapStateToProps)(Menu));