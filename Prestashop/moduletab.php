<?php

if (!defined('_PS_VERSION_'))
	exit;

class MonModule extends Module {
	public  $hookAssign   = array();
	public $_staticModel =  "";
	public function __construct() {

		$this->name = 'mymodule';
		$this->tab = 'front_office_features';
		$this->version = '1.0';
		$this->author = 'Simon Daigre';
		$this->need_instance = 0;
		$this->ps_versions_compliancy = array('min' => '1.5', 'max' => '1.6');
		parent::__construct();
		$this->admin_tpl_path = _PS_MODULE_DIR_ . $this->name . '/views/templates/admin/';
	}

	public function install() {
		$tab = new Tab();
		
		$tab->class_name = 'AdminMonModule';
		$tab->id_parent = (int)Tab::getIdFromClassName('AdminCartRules'); 
		$tab->module = $this->name;
		$tab->add();

		// Set some defaults
		return parent::install()
			&& $this->registerHook('displayHeader');
	}

	public function uninstall() {
		$tab = new Tab((int) Tab::getIdFromClassName('AdminMonModule'));
		$tab->delete();
		
		$this->registerHook('displayHeader');
		
		// Uninstall Module
		if (!parent::uninstall())
			return false;

		return true;
	}
}
